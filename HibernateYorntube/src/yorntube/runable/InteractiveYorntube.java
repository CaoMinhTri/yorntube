/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yorntube.runable;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import yorntube.persistence.*;
import yorntube.storageManager.StorageManager;

/**
 *
 * @author plthan
 */
public class InteractiveYorntube {

    private static final long LASTWEEK_TIMESTAMP = 1407381287;

    public static void main(String[] args) {
        InteractiveYorntube interactiveYorntube = new InteractiveYorntube();
        interactiveYorntube.startYorn();
    }

    private void startYorn() {

        StorageManager.beginTransaction();

        System.out.println("Welcome to yorntube, please select option in square brackets:");
        System.out.println("[1] Insert database");
        System.out.println("[2] Show the titles of all videos in the database");
        System.out.println("[3] Show the titles of all videos authored by a given user");
        System.out.println("[4] Show the titles of all videos authored by user one that user two commented on");
        System.out.println("[5] Show the titles of all videos that received comments during the last week");
        System.out.println("[6] Show the title of the video that received the most comments");
        System.out.println("[7] Show all users that authored HD videos");
        System.out.println("[0] EXIT");

        Scanner reader = new Scanner(System.in);
        int choose = -1;
        do {
            System.out.print("Your choose: ");
            String c = reader.next();
            try {
                choose = Integer.parseInt(c);

                switch (choose) {
                    case 1:
                        insertData();
                        break;
                    case 2:
                        getAllVideoTitles();
                        break;
                    case 3:
                        allVideoByGivenUser();
                        break;
                    case 4:
                        getVideosByUserOneCommentByUserTwo();
                        break;
                    case 5:
                        getVideosCommentSinceLastWeek();
                        break;
                    case 6:
                        mostCommendtedVideos();
                        break;
                    case 7:
                        allUsersHaveHDVideo();
                        break;
                    default:
                        System.out.println("Please try again with number in the brackets");
                }
            } catch (Exception e) {
                System.out.println("Invalid number! Please try again");
            }

        } while (choose != 0);
        System.out.println("Goodbye!");
        StorageManager.commitTransaction();
    }

    private void insertData() {
        try {

            User userOne = new User("Dogg", "dogg@animals.net");
            StorageManager.save(userOne);
            Video videoOne = new SDVideo("My Dogs");
            StorageManager.save(videoOne);

            userOne.author(videoOne);
            Comment commentOne = new Comment("I love my dogs,they are the best!", videoOne, userOne);
            StorageManager.save(commentOne);
            User userTwo = new User("Kitty", "kitty@animals.net");
            StorageManager.save(userTwo);
            Comment commentTwo = new Comment("Dogs are soooo lame!" + "My cats are way cooler!", videoOne, userTwo);
            StorageManager.save(commentTwo);
            Comment commentThree = new Comment("I need to see that, before I" + "believe your bold claims!", videoOne, userOne);
            StorageManager.save(commentThree);
            Video videoTwo = new HDVideo("Awesome Cat Action");
            StorageManager.save(videoTwo);

            userTwo.author(videoTwo);
            Comment commentFour = new Comment("There you go:" + "<- to: Awesome_Cat_Action>", videoOne, userTwo);
            StorageManager.save(commentFour);
            Comment commentFive = new Comment("Woah, those are really cool cats!" + "And even in HD!", videoTwo, userOne);
            StorageManager.save(commentFive);
            Video videoThree = new SDVideo("No Comment");
            StorageManager.save(videoThree);
            userTwo.author(videoThree);
            StorageManager.getSessionFactory().getCurrentSession().flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void getAllVideoTitles() {
        System.out.println("========================================");
        List listTitles = StorageManager.getAllVideosTitle();
        if (listTitles.isEmpty()) {
            System.out.println("There is no videos has been found!");
            return;
        }
        System.out.println("All video titles in database:");
        for (Iterator it = listTitles.iterator(); it.hasNext();) {
            String string = (String) it.next();
            System.out.println("" + string);
        }
    }

    private void allVideoByGivenUser() {
        System.out.println("========================================");
        long user_id = 5;
        List user = StorageManager.getUserByUserID(user_id);
        if (user.isEmpty()) {
            System.out.println("There is no user with user_id = " + user_id);
        } else {
            User u = (User) user.get(0);
            List listTitles = StorageManager.getAllVideosTitleByAuthor(u.getUser_id());

            if (listTitles.isEmpty()) {
                System.out.println("User has no video :D");
            } else {
                System.out.println("All video titles in database by " + u.getNickname());
                for (Iterator it = listTitles.iterator(); it.hasNext();) {
                    String string = (String) it.next();
                    System.out.println("" + string);
                }
            }
        }
    }

    private void getVideosByUserOneCommentByUserTwo() {
        System.out.println("========================================");
        List listTitles = StorageManager.getAllVideosCommented();
        if (listTitles.isEmpty()) {
            System.out.println("There is no video has been found!");
            return;
        }
        System.out.println("All video by userOne and comment by userTwo:");
        for (Iterator it = listTitles.iterator(); it.hasNext();) {
            String string = (String) it.next();
            System.out.println("" + string);
        }
    }

    private void getVideosCommentSinceLastWeek() {
        System.out.println("========================================");
        Timestamp t = new Timestamp(LASTWEEK_TIMESTAMP);
        List listTitles = StorageManager.getAllVideosCommentedLastweek(t);
        if (listTitles.isEmpty()) {
            System.out.println("There is no videos has been found!");
            return;
        }
        System.out.println("All videos that received comments during the last week:");
        for (Iterator it = listTitles.iterator(); it.hasNext();) {
            String string = (String) it.next();
            System.out.println("" + string);
        }
    }

    ;

    private void allUsersHaveHDVideo() {

        System.out.println("========================================");
        List listTitles = StorageManager.userHaveHDVideos();
        if (listTitles.isEmpty()) {
            System.out.println("There is no user!");
            return;
        }
        System.out.println("All users have HD video:");
        for (Iterator it = listTitles.iterator(); it.hasNext();) {
            String string = (String) it.next();
            System.out.println("" + string);
        }
    }

    private void mostCommendtedVideos() {

        System.out.println("========================================");
        List listTitles = StorageManager.getMostCommentedVideos();
        if (listTitles == null || listTitles.isEmpty()) {
            System.out.println("There is no videos has been found!");
            return;
        }
        System.out.println("The videos that received the most comment:");
        for (Iterator it = listTitles.iterator(); it.hasNext();) {
            Video v = (Video) it.next();
            System.out.println("" + v.getTitle());
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yorntube.persistence;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author plthan
 */
public class User {

    private long user_id;
    private String nickname;
    private String email;
    
    private Set<Comment> comments;
    private Set<Video> videos;
    private Set<Activity> activities; 

    public User() {
    }

    public User(String nickname, String email) {
        this.nickname = nickname;
        this.email = email;
        videos = new HashSet<>();
        activities = new HashSet<>();
    }

    public void author(Video video) {
        video.getActivities().add(new Activity(this, video, 1));
        this.videos.add(video);
    }

    /**
     * @return the user_id
     */
    public long getUser_id() {
        return user_id;
    }

    /**
     * @param user_id the user_id to set
     */
    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    /**
     * @return the nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname the nickname to set
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the activities
     */
    public Set<Activity> getActivities() {
        return activities;
    }

    /**
     * @param activities the activities to set
     */
    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }

    /**
     * @return the comments
     */
    public Set<Comment> getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    /**
     * @return the videos
     */
    public Set<Video> getVideos() {
        return videos;
    }

    /**
     * @param videos the videos to set
     */
    public void setVideos(Set<Video> videos) {
        this.videos = videos;
    }
}

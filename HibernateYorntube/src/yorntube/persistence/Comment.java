/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package yorntube.persistence;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author plthan
 */
public class Comment {
    private long comment_id;
    private Timestamp time;
    private String content;
    
    private Video video;
    private User user;

    public Comment() {
    }

    public Comment(String content, Video v, User u) {
        this.content = content;
        this.video = v;
        this.user = u;
        this.time = new Timestamp(new Date().getTime());
        v.getActivities().add(new Activity(u, v, 2));
    }

    /**
     * @return the comment_id
     */
    public long getComment_id() {
        return comment_id;
    }

    /**
     * @param comment_id the comment_id to set
     */
    public void setComment_id(long comment_id) {
        this.comment_id = comment_id;
    }

    /**
     * @return the time
     */
    public Timestamp getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(Timestamp time) {
        this.time = time;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the video
     */
    public Video getVideo() {
        return video;
    }

    /**
     * @param video the video to set
     */
    public void setVideo(Video video) {
        this.video = video;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }
}

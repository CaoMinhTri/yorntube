/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package yorntube.persistence;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author plthan
 */
public class Video {
    private long video_id;
    private String title;
    private Timestamp time;
    private String video_type;
    
    private Set<Comment> comments = new HashSet<>();
    private Set<Activity> activities = new HashSet<>();
    private User user;

    public Video() {
    }

    public Video(String title) {
        this.title = title;
        this.time = new Timestamp(new Date().getTime());
    }

    /**
     * @return the video_id
     */
    public long getVideo_id() {
        return video_id;
    }

    /**
     * @param video_id the video_id to set
     */
    public void setVideo_id(long video_id) {
        this.video_id = video_id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
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
     * @return the video_type
     */
    public String getVideo_type() {
        return video_type;
    }

    /**
     * @param video_type the video_type to set
     */
    public void setVideo_type(String video_type) {
        this.video_type = video_type;
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
}

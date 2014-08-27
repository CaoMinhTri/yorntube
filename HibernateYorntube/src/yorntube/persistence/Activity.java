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
public class Activity {
    private long activity_id;
    private Timestamp time;
    private long activity_type;
    private User user;
    private Video video;

    public Activity(User user, Video video, long activity_type) {
        this.user = user;
        this.video = video;
        this.activity_type = activity_type;
        this.time = new Timestamp(new Date().getTime());
    }

    /**
     * @return the activity_id
     */
    public long getActivity_id() {
        return activity_id;
    }

    /**
     * @param activity_id the activity_id to set
     */
    public void setActivity_id(long activity_id) {
        this.activity_id = activity_id;
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
     * @return the activity_type
     */
    public long getActivity_type() {
        return activity_type;
    }

    /**
     * @param activity_type the activity_type to set
     */
    public void setActivity_type(long activity_type) {
        this.activity_type = activity_type;
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
    
}

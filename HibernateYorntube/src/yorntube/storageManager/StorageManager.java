/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yorntube.storageManager;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author plthan
 */
public class StorageManager {

    private static final SessionFactory FACTORY = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return FACTORY;
    }

    public static Serializable save(Object o) {
        return getSessionFactory().getCurrentSession().save(o);
    }

    public static Transaction beginTransaction() {
        return getSessionFactory().getCurrentSession().beginTransaction();
    }

    public static void commitTransaction() {
        getSessionFactory().getCurrentSession().getTransaction().commit();
        getSessionFactory().close();
    }

    public static int updateAuthor(long user_id, long video_id) {
        String sql = "UPDATE Video v set v.author_id = :author_id WHERE v.video_id = :video_id";
        Query query = StorageManager.getSessionFactory().getCurrentSession().createQuery(sql);
        query.setParameter("author_id", user_id);
        query.setParameter("video_id", video_id);
        System.out.println("clgt: " + query.executeUpdate());
        return 1;
    }

    public static List getAllVideosTitle() {
        Query q = StorageManager.getSessionFactory().getCurrentSession().getNamedQuery("getAllVideosTitle");
        return q.list();
    }

    public static List getAllVideosTitleByAuthor(long author_id) {
        Query q = StorageManager.getSessionFactory().getCurrentSession().getNamedQuery("getAllVideosTitleByAuthor").setText("author_id", String.valueOf(author_id));
        return q.list();
    }

    public static List getUserByUserID(long user_id) {
        Query q = StorageManager.getSessionFactory().getCurrentSession().getNamedQuery("getUserByUserID").setLong("user_id", user_id);
        return q.list();
    }

    public static List getAllVideosCommented() {
        Query q = StorageManager.getSessionFactory().getCurrentSession().getNamedQuery("getAllVideosCommented");
        return q.list();
    }

    public static List userHaveHDVideos() {
        Query q = StorageManager.getSessionFactory().getCurrentSession().getNamedQuery("userHaveHDVideos");
        return q.list();
    }

    public static List getAllVideosCommentedLastweek(Timestamp timestamp) {
        Query q = StorageManager.getSessionFactory().getCurrentSession().getNamedQuery("getAllVideosCommentedLastweek");
        q.setParameter("lastweek", timestamp);
        q.setParameter("to", new Timestamp(new Date().getTime()));
        return q.list();
    }

    public static List getMostCommentedVideos() {
        Query qGetNumber = StorageManager.getSessionFactory().getCurrentSession().getNamedQuery("getMostCommentedNumber");
        try {
            int max = Integer.parseInt(qGetNumber.setMaxResults(1).list().get(0).toString());
            Query q = StorageManager.getSessionFactory().getCurrentSession().getNamedQuery("getMostCommented").setInteger("maxCount", max);
            return q.list();
        } catch (Exception e) {
            System.out.println("There is no comment yet");
            return Collections.EMPTY_LIST;
        }
    }
}

package by.kovalskij.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import by.kovalskij.dao.PersistException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vlad
 */
public class HibernateUtil {
 private static SessionFactory sessionFactory = null;
    
    static {
        try {
                sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            try {
                throw new PersistException(e);
            } catch (PersistException ex) {
                Logger.getLogger(HibernateUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static SessionFactory getSessionFactory() throws PersistException{
        return sessionFactory;
    }
}

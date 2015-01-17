package by.kovalskij.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;

import by.kovalskij.util.HibernateUtil;
import by.kovalskij.entity.Test;
import org.hibernate.HibernateException;

/**
 *
 * @author vlad
 */
public class TestDAOImpl implements TestDAO {

    @Override
    public void addTest(Test test) throws SQLException {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(test);
                session.getTransaction().commit();
            } catch (PersistException | HibernateException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
      }

    @Override
    public void updateTest(Test test) throws SQLException {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.update(test);
                session.getTransaction().commit();
            } catch (PersistException | HibernateException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
      }

    @Override
    public Test getTestById(Long id) throws SQLException {
            Session session = null;
            Test test = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                test = (Test) session.load(Test.class, id);
            } catch (PersistException | HibernateException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            return test;
      }

    @Override
    public List <Test> getAllTests() throws SQLException {
            Session session = null;
            List<Test> test = new ArrayList<>();
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                test = session.createCriteria(Test.class).list();
            } catch (PersistException | HibernateException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            return test;
      }

    @Override
    public void deleteTest(Test test) throws SQLException {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.delete(test);
                session.getTransaction().commit();
            } catch (PersistException | HibernateException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
      }  
    
}

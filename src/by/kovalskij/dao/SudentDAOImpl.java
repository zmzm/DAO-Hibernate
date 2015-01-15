package by.kovalskij.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;

import by.kovalskij.util.HibernateUtil;
import by.kovalskij.entity.Student;
import org.hibernate.HibernateException;
/**
 *
 * @author vlad
 */
public class SudentDAOImpl implements StudentDAO {
    
    @Override
    public void addStudent(Student stud) throws SQLException {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(stud);
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
      public void updateStudent(Student stud) throws SQLException {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.update(stud);
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
      public Student getStudentById(Long id) throws SQLException {
            Session session = null;
            Student stud = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                stud = (Student) session.load(Student.class, id);
            } catch (PersistException | HibernateException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            return stud;
      }

      @Override
      public List<Student> getAllStudents() throws SQLException {
            Session session = null;
            List<Student> studs = new ArrayList<>();
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                studs = session.createCriteria(Student.class).list();
            } catch (PersistException | HibernateException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
            } finally {
                if (session != null && session.isOpen()) {
                    session.close();
                }
            }
            return studs;
      }

      @Override
      public void deleteStudent(Student stud) throws SQLException {
            Session session = null;
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.delete(stud);
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

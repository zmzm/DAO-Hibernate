package by.kovalskij.dao;

/**
 *
 * @author vlad
 */
public class DAOFactory {
      
      private static StudentDAO studentDAO = null;
      private static DAOFactory instance = null;

      public static synchronized DAOFactory getInstance() throws PersistException {
            if (instance == null){
              instance = new DAOFactory();
            }
            return instance;
      }

      public StudentDAO getStudentDAO() throws PersistException {
            if (studentDAO == null){
              studentDAO = new SudentDAOImpl();
            }
            return studentDAO;
      }   
}

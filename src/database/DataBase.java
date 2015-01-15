package database;

import by.kovalskij.dao.DAOFactory;
import by.kovalskij.dao.PersistException;
import by.kovalskij.entity.Student;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author vlad
 */
public class DataBase {

    /**
     * @param args the command line arguments
     * @throws by.kovalskij.dao.PersistException
     * @throws java.sql.SQLException
     */
    
    public static void main(String[] args) throws PersistException, SQLException {
        //Создадим двух студентов
        Student s1 = new Student();
        Student s2 = new Student();
        
        //Проинициализируем их
        s1.setName("Ivan");
        s1.setSurname("Ivanov");
        s1.setDate("2007-11-12");
        s2.setName("Alisa");
        s2.setSurname("Petrova");
        s2.setDate("2007-11-13");
                
        //Сохраним их в бд, id будут сгенерированы автоматически
        DAOFactory.getInstance().getStudentDAO().addStudent(s1);
        DAOFactory.getInstance().getStudentDAO().addStudent(s2);      
        
        //Выведем всех студентов из бд
        List<Student> studs = DAOFactory.getInstance().getStudentDAO().getAllStudents();
        System.out.println("========Все студенты=========");
        for(int i = 0; i < studs.size(); ++i) {
                System.out.println("Имя студента : " + studs.get(i).getName() + ", Фамилия : " + studs.get(i).getSurname() +",  id : " + studs.get(i).getId());
                System.out.println("=============================");              
        }       
    }
}
    

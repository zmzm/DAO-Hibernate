package by.kovalskij.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
/**
 *
 * @author vlad
 */

@Entity
@Table(name="Student")
public class Student implements Serializable {
    
    private Long id;    
    private String name;    
    private String surname;
    private String enrolment_date;
    
    public Student(){
        name = null;
    }
    
    public Student(Student s){
        name = s.getName();
    }   
    
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
    public Long getId() {
        return id;
    }
    
    @Column(name="name")
    public String getName(){
        return name;
    }
    
    @Column(name="surname")
    public String getSurname(){
        return surname;
    }
    
    @Column(name="enrolment_date")
    public String getDate(){
        return enrolment_date;
    }
    
    public void setId(Long i){
        id = i;     
    }
    
    public void setName(String s){
        name = s;
    }   
    
    public void setSurname(String l){
        surname = l;
    }
    
    public void setDate(String d){
        enrolment_date = d;
    } 
}

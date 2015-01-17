package by.kovalskij.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author vlad
 */

@Entity
@Table(name="Test")
public class Test implements Serializable {
    
    private Long tid;   
    private String tname;   
    
    public Test(){
        tname = null;
    }
    
    public Test(Test s){
        tname = s.getTName();
    }
    
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="tid")
    public Long getTid() {
        return tid;
    }
    
    @Column(name="tname")
    public String getTName(){
        return tname;
    }
    
    public void setId(Long i){
        tid = i;        
    }
    
    public void setTName(String s){
        tname = s;
    } 
    
    private Statistics stat;

    /**
     *
     * @return
     */
    @ManyToOne
    @JoinTable(name = "id")
    public Statistics getStat(){
        return stat;
    }
}

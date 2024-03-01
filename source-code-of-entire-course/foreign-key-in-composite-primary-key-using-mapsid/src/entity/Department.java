package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Department {

    //for Hibernate 4.3.x Users
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    // for Hibernate 5.x Users
    // if you're using Hibernate 5.x, use GenerationType.IDENTITY id generator strategy explicitly
    // for more information on "GenerationType" have a look at https://www.udemy.com/hibernate-and-jpa-fundamentals/learn/v4/questions/937412
    /*
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    */

    @Column(nullable=false)
    protected String name;

    public Department() {}
    public Department(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}   
	
}

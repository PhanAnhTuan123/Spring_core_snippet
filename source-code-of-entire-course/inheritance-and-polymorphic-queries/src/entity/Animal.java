package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE) 
//@Inheritance(strategy=InheritanceType.JOINED) // to be used when you want to test JOINED strategy for inheritance mapping
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS) // to be used when you want to test TABLE_PER_CLASS (Table Per Concrete Class) strategy for inheritance mapping
public abstract class Animal {
	
	//for Hibernate 4.3.x Users
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	//@GeneratedValue(strategy=GenerationType.TABLE) // to be used when using TABLE_PER_CLASS strategy
	private Long id;
	
	// for Hibernate 5.x Users
	// if you're using Hibernate 5.x, use GenerationType.IDENTITY id generator strategy explicitly, except when using TABLE_PER_CLASS strategy, for which use GenerationType.TABLE
	// for more information on "GenerationType" have a look at https://www.udemy.com/hibernate-and-jpa-fundamentals/learn/v4/questions/937412
	/*
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	//@GeneratedValue(strategy=GenerationType.TABLE) // to be used when using TABLE_PER_CLASS strategy
	private Long id;
	*/
	
	//@Column(nullable=false) // cannot be used when using SINGLE_TABLE strategy
	private String name;	
	
	public void setName(String name) { 	
		this.name = name; 
	}
	
	public abstract String makeNoise();
	
	public String toString() {
		return name + " making " + makeNoise() + " noises";
	}	

}

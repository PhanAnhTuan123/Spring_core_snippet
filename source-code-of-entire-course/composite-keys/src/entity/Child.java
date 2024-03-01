package entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Entity
public class Child {
	
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
	
	private String name;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="firstname_fk", referencedColumnName="firstname"),
		@JoinColumn(name="lastname_fk", referencedColumnName="lastname")
	})
	private Parent parent;

	public Child() {}
	public Child(String name) {
		this.name = name;
	}
	
	public void setParent(Parent parent) {
		this.parent = parent;
	}

}

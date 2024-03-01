package entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Account {
	
	//for Hibernate 4.3.x Users
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	// for Hibernate 5.x Users
	// if you're using Hibernate 5.x, use GenerationType.IDENTITY id generator strategy explicitly
	// for more information on "GenerationType" have a look at https://www.udemy.com/hibernate-and-jpa-fundamentals/learn/v4/questions/937412
	/*
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	*/

	private String owner;
	private BigDecimal balance;
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
}

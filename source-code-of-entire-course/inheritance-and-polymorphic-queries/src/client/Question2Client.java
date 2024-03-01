package client;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entity.Cat;
import entity.Dog;

public class Question2Client {
	public static void main(String[] args) {		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();   
		
		/*
		Cat cat = new Cat(); 
		cat.setName("Lucy");
		cat.setPurringLevel(6);	//uncomment setPurringLevel() method in Cat class

		Dog dog = new Dog();
		dog.setName("Oliver");
		dog.setBarkingLevel(3);  //uncomment setBarkingLevel() method in Dog class

		em.persist(cat);
		em.persist(dog);
		*/

		em.getTransaction().commit();
		em.close();
	}
}



































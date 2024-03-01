package client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Hibernate;

import entity.Student;

public class GettingAReferenceClient {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");	
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Student student = em.getReference(Student.class, 3L);
		String studentName = student.getName(); //issues SELECT and initializes the proxy
		//Hibernate.initialize(student); //issues SELECT and initializes the proxy
		
		em.getTransaction().commit();
		em.close(); 
	}
}

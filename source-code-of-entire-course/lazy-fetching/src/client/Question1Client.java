package client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Guide;
import entity.Student;

public class Question1Client {
	public static void main(String[] args) {		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();		
	
		Guide guide = em.find(Guide.class, 3L);
		em.detach(guide);		
		System.out.println(guide.getStudents().size());
		
		txn.commit();	
		em.close();         
	}
}




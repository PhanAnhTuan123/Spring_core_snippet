package client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Message;

public class Question1Client {
	public static void main(String[] args) {		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		
		Message message = new Message("Hello");     
		em.persist(message);    
		
		em.detach(message);
		
		txn.commit();	
		em.close();         
	}
}




package client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;

import entity.Guide;

public class Question1Client {	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();		
		
		Guide guide1 = em.find(Guide.class, 2L);
		Guide guide2 = (Guide) em.createQuery("select guide from Guide guide where guide.id = :id").setParameter("id", 2L).getSingleResult();			
		Guide guide3 = (Guide) em.createQuery("select guide from Guide guide where guide.name = :name").setParameter("name", "Ian Lamb").getSingleResult();

	
		em.getTransaction().commit();
		em.close();	

	}
}

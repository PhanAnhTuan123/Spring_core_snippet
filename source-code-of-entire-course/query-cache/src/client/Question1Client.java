package client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;

import entity.Guide;

public class Question1Client {		
	@SuppressWarnings("unused")
	public static void main(String[] args) {		
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");	
				
				Statistics stats = emf.unwrap(SessionFactory.class).getStatistics();
				stats.setStatisticsEnabled(true);
				
				EntityManager em1 = emf.createEntityManager();
				em1.getTransaction().begin();
				 
				Guide guide1 = (Guide) em1.createQuery("select guide from Guide guide where guide.name = :name")
																  .setParameter("name", "Ian Lamb")
																  .getSingleResult();	
				
				Guide guide2 = (Guide) em1.createQuery("select guide from Guide guide where guide.name = :name")
																  .setParameter("name", "Ian Lamb")
																  .getSingleResult();	
				
				em1.getTransaction().commit();
				em1.close(); 

	}
}

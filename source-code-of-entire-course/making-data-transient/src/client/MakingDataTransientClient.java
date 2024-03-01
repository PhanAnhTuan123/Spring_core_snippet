package client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Student;

public class MakingDataTransientClient {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");	
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Student student = em.find(Student.class, 3L);
		em.remove(student);

		Long id = student.getId();
		//em.persist(student);
		
		em.getTransaction().commit();
		em.close(); 
		
		EntityManager em2 = emf.createEntityManager();
		em2.getTransaction().begin();
		
		em2.persist(student);
		//Student student2 = em2.merge(student);

		em2.getTransaction().commit();
		em2.close(); 
	}
}

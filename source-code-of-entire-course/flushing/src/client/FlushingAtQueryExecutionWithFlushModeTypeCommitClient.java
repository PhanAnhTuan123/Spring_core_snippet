package client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entity.Student;

public class FlushingAtQueryExecutionWithFlushModeTypeCommitClient {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");	
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Student student = em.find(Student.class, 2L);
		student.setName("Sherry Morgan");
		
		em.setFlushMode(FlushModeType.COMMIT);
		Query query = em.createQuery("select s.name from Student s where s.id = :id").setParameter("id", 2L);
		String name = (String) query.getSingleResult();
	
		em.getTransaction().commit();
		em.close(); 
	}
}
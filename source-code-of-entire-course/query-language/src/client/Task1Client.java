
package client;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entity.Guide;
import entity.Student;

public class Task1Client {
	public static void main(String[] args) {		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();   
		
		Query query = em.createQuery("select s.name, s.enrollmentId from Student s where s.guide is null");
		List<Object[]> resultList = query.getResultList();
		for (Object[] objects : resultList) {
			System.out.println("Object[] {objects[0]: " + objects[0] + ", objects[1]: " + objects[1] + "}");				
		}

		em.getTransaction().commit();
		em.close();
	}
}



































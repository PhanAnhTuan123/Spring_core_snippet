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

public class Task3Client {
	public static void main(String[] args) {		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();   
		
		Query query = em.createQuery(" select g from Guide g join g.students s where s.name like 'A%' ");
		List<Guide> resultList = query.getResultList();
		for (Guide guide : resultList) {
			System.out.println(guide);
		}

		em.getTransaction().commit();
		em.close();
	}
}



































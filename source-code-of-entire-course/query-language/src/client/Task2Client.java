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

public class Task2Client {
	public static void main(String[] args) {		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();   
		
		//1 and 2 both works fine
		/*
		Query query = em.createQuery("select g.name, g.staffId from Guide g where g.students.size is 0"); //1
		*/
		Query query = em.createQuery("select g.name, g.staffId from Guide g where size(g.students) is 0"); //2
		List<Object[]> resultList = query.getResultList();
		for (Object[] objects : resultList) {
			System.out.println("Object[] {objects[0]: " + objects[0] + ", objects[1]: " + objects[1] + "}");				
		}

		em.getTransaction().commit();
		em.close();
	}
}



































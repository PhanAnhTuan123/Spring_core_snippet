
package client;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entity.Guide;
import entity.Student;

public class Question1Client {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		
		EntityManager em1 = emf.createEntityManager();
		em1.getTransaction().begin();

		Student student1 = em1.find(Student.class, 2L);

		em1.getTransaction().commit();
		em1.close();

		EntityManager em2 = emf.createEntityManager();
		em2.getTransaction().begin();

		Student student2 = em2.find(Student.class, 2L);
		        
		System.out.println(student1.equals(student2));

		em2.getTransaction().commit();
		em2.close();

        
	}
}




































package client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entity.Guide;
import entity.Student;

public class BatchFetchingClient {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();

			//Loading all the students lazily; the guides associated with students are "not" being accessed
			/*
			Query query = em.createQuery("select student from Student student");
			List<Student> students = query.getResultList();	

			for (Student student : students) {
				System.out.println(student.getName() + ": " + student.getEnrollmentId());
			}  
			*/

			//Loading all the students lazily using @BatchSize(size=2); the guides associated with students are being accessed
			Query query = em.createQuery("select student from Student student");
			List<Student> students = query.getResultList();	

			for (Student student : students) {
				if(student.getGuide() != null) {				
					System.out.println(student.getName() + ": " + student.getEnrollmentId() + ": " + student.getGuide().getName());
				}
			}  					

			txn.commit();			
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}

	}
}















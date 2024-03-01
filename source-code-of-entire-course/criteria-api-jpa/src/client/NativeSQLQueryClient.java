package client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import entity.Guide;
import entity.Student;

public class NativeSQLQueryClient {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();						
			
			//NATIVE-SQL QUERY			
			Query query = em.createNativeQuery("select * from student", Student.class);
			List<Student> students = query.getResultList();
			for (Student student : students) {
				System.out.println(student);
			}			
			
			/*
			Query query = em.createNativeQuery("select name, enrollment_id from student");
			List<Object[]> result = query.getResultList();
			for (Object[] tuple : result) {
				System.out.println("name: " + tuple[0] + ", enrollment_id: " + tuple[1]);
			}
			*/
			
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















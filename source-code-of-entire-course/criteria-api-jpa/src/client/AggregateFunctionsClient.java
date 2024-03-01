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

//generated Guide_ metamodel after enabling Annotation Processing
//import entity.Guide_;

//generated Student_ metamodel after enabling Annotation Processing
//import entity.Student_;

public class AggregateFunctionsClient {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();	
			
			//AGGREGATE FUNCTION - count			
			CriteriaBuilder builder = em.getCriteriaBuilder();

			CriteriaQuery<Long> criteria = builder.createQuery( Long.class );
			Root<Guide> root = criteria.from( Guide.class );
			criteria.select(builder.count(root));
			
			TypedQuery<Long> query = em.createQuery(criteria);
			Long numOfGuides = query.getSingleResult();
			System.out.println(numOfGuides);
				
			//############################
			
			//AGGREGATE FUNCTION - max
			/*
			CriteriaBuilder builder = em.getCriteriaBuilder();

			CriteriaQuery<Integer> criteria = builder.createQuery( Integer.class );
			Root<Guide> root = criteria.from( Guide.class );
			Path<Integer> salary = root.get("salary");
			//Path<Integer> salary = root.get(Guide_.salary);
			criteria.select(builder.max(salary));
			
			TypedQuery<Integer> query = em.createQuery(criteria);
			Integer maxSalary = query.getSingleResult();
			System.out.println(maxSalary);
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















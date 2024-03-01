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

public class NamedQueriesClient {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();			
	
			//NAMED QUERY - using orm.xml				
			TypedQuery<Guide> typedQuery = em.createNamedQuery("findByGuide", Guide.class)
																				 .setParameter("name", "Ian Lamb");
			List<Guide> guides = typedQuery.getResultList();
			for (Guide guide : guides) {
				System.out.println(guide);
			}
			
			//############################
			
			//NAMED QUERY - using @NamedQuery annotation in Guide entity
			/*
			TypedQuery<Guide> typedQuery = em.createNamedQuery("Guide.findByName", Guide.class)
																				 .setParameter("name", "Ian Lamb");
			List<Guide> guides = typedQuery.getResultList();
			for (Guide guide : guides) {
				System.out.println(guide);
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















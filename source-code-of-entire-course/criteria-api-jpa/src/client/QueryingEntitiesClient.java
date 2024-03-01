
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

public class QueryingEntitiesClient {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();			
			
			//QUERYING ENTITIES						
			CriteriaBuilder builder = em.getCriteriaBuilder();

			CriteriaQuery<Guide> criteria = builder.createQuery( Guide.class );
			Root<Guide> root = criteria.from( Guide.class );
			criteria.select(root);
			
			TypedQuery<Guide> query = em.createQuery(criteria);
			List<Guide> guides = query.getResultList();
			for (Guide guide : guides) {
				System.out.println(guide);
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















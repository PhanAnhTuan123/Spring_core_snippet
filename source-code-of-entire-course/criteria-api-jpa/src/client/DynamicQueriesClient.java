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

public class DynamicQueriesClient {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();						

			//DYNAMIC QUERIES	
			String name = "Ian Lamb"; //simulating dynamic query
			
			CriteriaBuilder builder = em.getCriteriaBuilder();

			CriteriaQuery<Guide> criteria = builder.createQuery( Guide.class );
			Root<Guide> root = criteria.from( Guide.class );
			criteria.where( builder.equal(root.get("name"), builder.parameter(String.class, "name") ) );
			//criteria.where( builder.equal(root.get(Guide_.name), builder.parameter(String.class, "name") ) );
			criteria.select(root);			

			TypedQuery<Guide> query = em.createQuery(criteria).setParameter("name", name);
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















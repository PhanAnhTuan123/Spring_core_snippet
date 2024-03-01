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

public class ReportQueriesClient {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();			
			
			//REPORT QUERIES - using builder.array or multiselect
			CriteriaBuilder builder = em.getCriteriaBuilder();

			CriteriaQuery<Object[]> criteria = builder.createQuery( Object[].class );
			Root<Guide> root = criteria.from( Guide.class );

			Path<String> name = root.get( "name" );
			Path<Integer> salary = root.get( "salary" );
			//Path<String> name = root.get(Guide_.name);
			//Path<Integer> salary = root.get(Guide_.salary);

			//criteria.multiselect( name, salary );
			criteria.select( builder.array( name, salary ) );

			TypedQuery<Object[]> query = em.createQuery(criteria);
			List<Object[]> resultList = query.getResultList();
			for (Object[] objects : resultList) {
				System.out.println("Object[] {objects[0]: " + objects[0] + ", objects[1]: " + objects[1] + "}");				
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















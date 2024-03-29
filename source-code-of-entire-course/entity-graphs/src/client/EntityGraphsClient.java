package client;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Guide;

public class EntityGraphsClient {
	@SuppressWarnings("unused")
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-world");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		try {
			txn.begin();
	
			//Using find() - Eagerly loading the students associated with Guide[id=2L] using "Guide.students" entity-graph			
			Map<String,Object> props = new HashMap<String,Object>();
			props.put("javax.persistence.loadgraph", em.getEntityGraph("Guide.students"));
			Guide guide = em.find(Guide.class, 2L, props );
			

			//Using JPQL - Eagerly loading the students associated with Guide[id=2L] using "Guide.students" entity-graph
			/*
			Guide guide = em.createQuery("select g from Guide g where g.id = :id", Guide.class)
										.setParameter("id", 2L)
										.setHint("javax.persistence.loadgraph", em.getEntityGraph("Guide.students"))
										.getSingleResult();
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
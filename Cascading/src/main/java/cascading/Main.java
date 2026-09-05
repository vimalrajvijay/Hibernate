package cascading;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		 EntityManagerFactory emf 
		= Persistence.createEntityManagerFactory("vimal");
		 EntityManager em1 = emf.createEntityManager();
		 EntityManager em2 = emf.createEntityManager();
//		 EntityTransaction et = em.getTransaction();
		  
//		 Car c1 = new Car();
//		 c1.setBrand("BMW");
//		 c1.setPrice(10000);
//		 
//		 Engine e1 = new Engine();
//		 e1.setType("Petrol");
//		 e1.setHp(1200);
		 
//		 c1.setEngine(e1);
		 
//		 et.begin();
//		 em.persist(c1);// Engine also persisted.
//		 et.commit();
	}
}

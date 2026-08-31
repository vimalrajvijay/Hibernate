package view;

import entity.Car;
import entity.Engine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Save {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vimal");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		
		Engine e1 = new Engine("Petrol", 1200);
		Car c1 = new Car("BMW", 10000, e1);
		
		et.begin();
		em.persist(e1);
		em.persist(c1);
		et.commit();
		
	}

}

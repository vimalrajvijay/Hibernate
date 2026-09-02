package one_to_one;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vimal");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Car car = new Car();
		car.setBrand("BMW");
		car.setPrice(10000);
		
		Engine engine = new Engine();
		engine.setType("Petrol");
		engine.setHp(1200);
		
		car.setEngine(engine);
		engine.setCar(car);
		
		et.begin();
		em.persist(engine);
		em.persist(car);
		et.commit();
	}
}

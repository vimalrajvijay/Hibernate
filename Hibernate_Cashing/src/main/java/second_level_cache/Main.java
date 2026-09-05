package second_level_cache;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/*
 * Steps to implement second level cache:
 * step 1: Add ehcache dependency of similar version of Hibernate
 * step 2: Add tags in the persistence.xml (Take from GitHub)
 * step 3: Add @Cachable on the entity*/

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf 
		= Persistence.createEntityManagerFactory("vimal");
		 EntityManager em1 = emf.createEntityManager();
		 EntityManager em2 = emf.createEntityManager();
		 EntityTransaction et = em1.getTransaction();
		 
		 //First_level_cache
//		 Movie movie1=em1.find(Movie.class, 1);
//		 Movie movie2=em1.find(Movie.class, 1);//select query is not executed
		 
		 
//		 Movie movie2=em2.find(Movie.class, 1);//select query is executed
		 
		 // Second_level_cache
		 Movie movie1=em1.find(Movie.class, 1);
		 Movie movie2=em2.find(Movie.class, 1);//select query is not executed
		 System.out.println(movie1);
//		 Movie m1 = new Movie();
//		 m1.setName("Leo");
//		 m1.setRating(4.5);
//		 
//		 et.begin();
//		 em1.persist(m1);
//		 et.commit();
	}
}

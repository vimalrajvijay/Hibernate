package one_to_many;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vimal");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Account a1 = new Account(1234, "abc");
		Account a2 = new Account(4321, "mno");
		Account a3 = new Account(6789, "xyz");
		
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(a1);
		accounts.add(a2);
		accounts.add(a3);
		
		Bank b1 = new Bank("ICICI", "ICI123", accounts);
		
		et.begin();
		em.persist(a1);
		em.persist(a2);
		em.persist(a3);
		em.persist(b1);
		et.commit();
	}
}

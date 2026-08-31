package repository;

import java.util.List;

import org.hibernate.query.Query;

import entity.Employee;
import exception.EmployeeNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class EmployeeRepository {
	
	private EntityManagerFactory emf 
	= Persistence.createEntityManagerFactory("vimal");
	private EntityManager em = emf.createEntityManager();
	private EntityTransaction et = em.getTransaction();
	
	public void addEmployee(Employee employee) {
		try {
			et.begin();
			em.persist(employee);
			et.commit();
			System.out.println("Saved");
		}catch (Exception e) {
			et.rollback();
		}
	}
	
	public Employee findEmployee(int id) {
		Employee  employee= em.find(Employee.class, id);
		if(employee!=null)
			return employee;
		else
			throw new EmployeeNotFoundException("Employee Not Found");
	}
	
	public Employee updateEmployee(int id) {
		Employee employee = findEmployee(id);
		double existingSalary = employee.getSalary();
		double updatedSalary = existingSalary 
				            + (10.0/100 * existingSalary);
		employee.setSalary(updatedSalary);
		try {
			et.begin();
			em.merge(employee);
			et.commit();
		}catch (Exception e) {
			et.rollback();
		}
		return employee;
	}
	public void deleteEmployee(int id) {
		Employee employee = findEmployee(id);
		try {
			et.begin();
			em.remove(employee);
			et.commit();
			System.out.println("Deleted");
		}catch (Exception e) {
			et.rollback();
		}
	}
	public List<Employee> findAllEmployees() {
		String jpql = "select e from Employee e";
		
		jakarta.persistence.Query query =  em.createQuery(jpql);
		return query.getResultList();
	}
}

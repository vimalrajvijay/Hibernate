package view;

import java.util.Scanner;

import entity.Employee;
import repository.EmployeeRepository;

public class Main {
	
	static EmployeeRepository employeeRepository 
	= new EmployeeRepository();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Add Employee");
		System.out.println("2. Find Employee based on ID");
		System.out.println("3. Update Employee");
		System.out.println("4. Remove Employee");
		System.out.println("5. Find all employees");
		
		System.out.print("Enter the option : ");
		int option = sc.nextInt();
		switch (option) {
		case 1:
			System.out.print("ID : ");
			int id = sc.nextInt();
			System.out.print("Name : ");
			String name = sc.next();
			System.out.print("Salary : ");
			double salary = sc.nextDouble();
			System.out.print("Dept : ");
			String dept = sc.next();
			Employee employee = new Employee(id, name, salary, dept);
			employeeRepository.addEmployee(employee);
			break;
		case 2:
			System.out.print("ID : ");
			id = sc.nextInt();
			System.out.println(employeeRepository.findEmployee(id));
			break;
		case 3:
			System.out.print("ID : ");
			id = sc.nextInt();
			System.out.println(employeeRepository.updateEmployee(id));
			break;
		case 4:
			System.out.print("ID : ");
			id = sc.nextInt();
			employeeRepository.deleteEmployee(id);
		case 5:
			System.out.println(employeeRepository.findAllEmployees());
			break;
		default:
			break;
		}
	}
}

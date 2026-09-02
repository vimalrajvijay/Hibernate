package view;

import java.util.ArrayList;
import java.util.List;

import many_to_many.Course;
import many_to_many.Student;
import repository.StudentRepository;

public class Main {

	public static void main(String[] args) {
		
		StudentRepository repository = new StudentRepository();
		
		System.out.println("1. Add Student");
		System.out.println("2. Find Student");
		int option = 2;
		switch (option) {
		case 1:
			Course c1 = new Course("Java", 10000);
			Course c2 = new Course("Python", 10000);
			Course c3 = new Course("SQL", 8000);
			
			List<Course> courses1 = new ArrayList<Course>();
			courses1.add(c1);
			courses1.add(c3);
			
			List<Course> courses2 = new ArrayList<Course>();
			courses2.add(c2);
			
			List<Course> courses3 = new ArrayList<Course>();
			courses3.add(c2);
			
			Student s1 = new Student("abc", 20, courses1);
			Student s2 = new Student("xyz", 22, courses2);
			Student s3 = new Student("mno", 21, courses3);
			
			List<Student> students = new ArrayList<Student>();
			students.add(s1);
			students.add(s2);
			students.add(s3);
			
			List<Course> courses = new ArrayList<Course>();
			courses.add(c1);
			courses.add(c2);
			courses.add(c3);
			
			repository.saveStudent(students, courses);
			break;
		case 2:
			int id = 1;
			repository.findStudent(id);
			break;

		default:
			break;
		}
	}
}

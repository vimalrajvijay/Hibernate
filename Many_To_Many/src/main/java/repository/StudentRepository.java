package repository;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import many_to_many.Course;
import many_to_many.Student;

public class StudentRepository {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("vimal");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void saveStudent(List<Student> students, List<Course> courses) {

		et.begin();
		for (Course course : courses) {
			em.persist(course);
		}
		for (Student student : students) {
			em.persist(student);
		}
		et.commit();
	}

	public void findStudent(int id) {
		Student student = em.find(Student.class, id);
		List<Course> courses = student.getCourses();
		System.out.println("Student Details :");
		System.out.println(student);
		System.out.println("Course Details  : ");
		for(Course course : courses)
			System.out.println(course);
	}
}

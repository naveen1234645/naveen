package org.example.hibernate_set_crud.dao;




import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.persistence.Query;

import org.example.hibernate_set_crud.StudentNotFoundException;
import org.example.hibernate_set_crud.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentDaoImpl implements StudentDao {
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
			.buildSessionFactory();

	private static Scanner scanner = new Scanner(System.in);

	@Override
	public Student createStudent(Student student) {
		Session session = factory.getCurrentSession();
		session.getTransaction().begin();
		session.save(student);
		session.getTransaction().commit();

		return student;
	}

	@Override
	public List<Student> displayAllStudents() {
		Session session = factory.openSession();
		Query query = session.createQuery("select E from Student E");
		return query.getResultList();
	}

	@Override
	public Student findById(int id) {
		Session session = factory.openSession();
		Student student = session.get(Student.class, id);
		return student;
	}

	@Override
	public void deleteById(int id) {

		Session session = factory.openSession();
		Student tempStud = session.get(Student.class, id);
		if (tempStud == null) {
			throw new StudentNotFoundException("Student not found");
		}
		session.getTransaction().begin();
		session.remove(tempStud);
		session.getTransaction().commit();

	}

	@Override
	public Student updateById(int id) {
		Session session = factory.openSession();
		Student tempStud = session.get(Student.class, id);
		if (tempStud == null) {
			throw new StudentNotFoundException("Student not found");
		}

		System.out.print("First Name: ");
		String firstName = scanner.next();
		System.out.print("Last Name: ");
		String lastName = scanner.next();
		System.out.print("Email: ");
		String gmail = scanner.next();
		tempStud.setFirstName(firstName);
		tempStud.setLastName(lastName);
		tempStud.setGmail(gmail);

		Set<String> set = tempStud.getImages();

		System.out.println("Do you need to change images(yes/no)");
		String c = scanner.next();
		if (c.equals("yes")) {

			tempStud.setImages(null);
			System.out.println("How many images want to enter");
			int a = scanner.nextInt();
			Set<String> set1 = new HashSet<String>();
			for (int i = 0; i < a; i++) {
				System.out.println("Enter image name" + id);
				String image1 = scanner.next();

				set1.add(image1);
				tempStud.setImages(set1);
			}
		}
		session.getTransaction().begin();
		session.merge(tempStud);
		session.getTransaction().commit();

		return tempStud;
	}

}

package org.example.demo;


import org.example.demo.model.Student;
import org.example.demo.model.University;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Tester {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).addAnnotatedClass(University.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
	}

}
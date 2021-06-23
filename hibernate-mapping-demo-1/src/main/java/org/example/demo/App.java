package org.example.demo;

import java.util.logging.Logger;

import org.example.demo.model.Instructor;
import org.example.demo.model.InstructorDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * Hello world!
 *
 */

public class App {
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("org.example.demo.App.class");
		try {

			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class)
					.buildSessionFactory();
			Session session = factory.getCurrentSession();
			/*
			 * Instructor instructor=new Instructor(); InstructorDetails details=new
			 * InstructorDetails(); details.setHobby("Singing");
			 * details.setYoutubeChannel("channel-1"); instructor.setFirstName("John");
			 * instructor.setLastName("Doe"); instructor.setEmail("john@email.com");
			 * instructor.setInstructorDetails(details); session.getTransaction().begin();
			 * session.persist(instructor); session.getTransaction().commit();
			 */
    	   session.getTransaction().begin();
    	   Instructor instructor=session.get(Instructor.class, 1);
			/*
			 * 
			 * session.getTransaction().begin(); Instructor
			 * instructor=session.get(Instructor.class, 1);
			 * 
			 * InstructorDetails details=instructor.getInstructorDetails();
			 * details.setHobby("Cricket"); details.setYoutubeChannel("my-channel-1");
			 * instructor.setEmail("john1@email.com"); session.merge(instructor);
			 * session.getTransaction().commit();
			 * 
			 * 
			 * session.delete(instructor); session.getTransaction().commit();
			 * System.out.println("done");
			 */

    	   session.delete(instructor);
    	   session.getTransaction().commit();
    	   System.out.println("done");


	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
			InstructorDetails details = new InstructorDetails();
			details.setHobby("Singing");
			details.setYoutubeChannel("channel-1");
			Instructor instructor = new Instructor();
			instructor.setFirstName("John");
			instructor.setLastName("doe");
			instructor.setEmail("john@email.com");
			details.setInstructor(instructor);
			instructor.setInstructorDetails(details);
			session.getTransaction().begin();
			session.persist(details);
			session.persist(instructor);
			session.getTransaction().commit();
			logger.info("done");

		
	}
    }
}
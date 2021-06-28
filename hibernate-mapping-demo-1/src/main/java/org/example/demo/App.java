package org.example.demo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.Scanner;
import java.util.logging.Logger;

import org.example.demo.model.Instructor;
import org.example.demo.model.InstructorDetails;
import org.example.demo.model.Course;
import org.example.demo.model.People;

/**
 * Hello world!
 *
 */
public class App {

    @SuppressWarnings("unchecked")
	public static void main( String[] args )
    {
    	Logger logger=Logger.getLogger("org.example.App.class");
       try {

    	   SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class)
					.addAnnotatedClass(Course.class).addAnnotatedClass(People.class).buildSessionFactory();


    	   Session session = factory.getCurrentSession();
    	  
    	 
    	  // Session session= sessionFactory.getCurrentSession();

    	   Instructor instructor = new Instructor();
			InstructorDetails details = new InstructorDetails();
			details.setHobby("Singing");
			details.setYoutubeChannel("channel-1");
			instructor.setFirstName("John");
			instructor.setLastName("Doe");
			instructor.setEmail("john@email.com");
			instructor.setInstructorDetails(details);
			session.getTransaction().begin();

    	  // Instructor instructor=new Instructor();
			Course course1 = new Course();
			course1.setCourseName("Java");
			instructor.add(course1);
			Course course2 = new Course();

			course2.setCourseName("Angular");
			instructor.add(course2);
			//session.persist(instructor);
			//session.getTransaction().commit();
			People people1 = new People();
			people1.setFirstName("p1");
			people1.setLastname("q1");
			people1.setEmail("r1");
			session.persist(instructor);
			List<Course> list = new ArrayList<Course>();
			list.add(course1);
			list.add(course2);
			people1.setCourses(list);
			session.persist(people1);
			session.getTransaction().commit();
			

    	  /* Instructor instructor=new Instructor();
    	   InstructorDetails details=new InstructorDetails();
    	   instructor.setFirstName("ramu");
    	   instructor.setLastName("raju");
    	   instructor.setEmail("ramu@email.com");

    	   details.setYoutubeChannel("my-channel-2");
    	   details.setHobby("reading");
    	   instructor.setInstructorDetails(details);
    	   details.setInstructor(instructor);
    	   session.getTransaction().begin();
    	   session.persist(instructor);
    	   session.getTransaction().commit();
    	   logger.info("Done!");*/
//    
    	   //For Display
//    	   session=sessionFactory.openSession();
//      List<Instructor> list=new ArrayList<Instructor>();
//      Query query=session.createQuery("Select e from Instructor e");
//      
//      list=query.getResultList();
//      Iterator<Instructor> i=list.iterator();
//      while(i.hasNext())
//    	  {
//    	  System.out.println(i.next());
//       }

//    	   For Remove
//    	   session.getTransaction().begin();
//    	   
//    	   session.remove(session.get(Instructor.class, 1));
//    	   session.getTransaction().commit();
//   		System.out.println("Employee Deleted Successfully!");
       }catch(Exception e)
       {
    	   e.printStackTrace();
       }
    }
}
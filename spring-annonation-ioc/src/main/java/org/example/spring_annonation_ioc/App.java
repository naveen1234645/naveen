package org.example.spring_annonation_ioc;

import org.example.spring_annonation_ioc.model.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource")
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			Person person = context.getBean("person", Person.class);
			System.out.println(person);

			person.setEmail("john@email.com");
			person.setFirstName("john");
			person.setLastName("doe");
			person.setPersonId(100);
			System.out.println(person);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
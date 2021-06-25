package org.example.spring_annonation_ioc;

import org.example.spring_annonation_ioc.model.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args )
    {
    	try {
    		@SuppressWarnings("resource")
			ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
    		Person person=context.getBean("thePerson",Person.class);
    		person.setEmail("john@email.com");
    		person.setFirstName("john");
    		person.setLastName("doe");
    		person.setPersonId(100);
    		System.out.println(person);
    		
    		Person person1 = context.getBean("thePerson", Person.class);
			System.out.println(person1);
			System.out.println(person==person1);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
    }
}
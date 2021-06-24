package org.example.demo;

import org.example.demo.model.Coach;
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
        	Coach theCoach=context.getBean("theCoach",Coach.class);
        	System.out.println(theCoach.getDailyworkOut());
        	Coach theCoach2=context.getBean("theCoach",Coach.class);
        	System.out.println(theCoach==theCoach2);

		} catch (Exception e) {
			// TODO: handle exception
		}
    }
}

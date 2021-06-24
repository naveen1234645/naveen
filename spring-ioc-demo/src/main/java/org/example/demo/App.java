package org.example.demo;



import java.util.UUID;

import org.example.demo.model.Coach;
import org.example.demo.model.CricketCoach;
import org.example.demo.model.Customer;
import org.example.demo.model.InternationalCD;
import org.example.demo.model.SpecialEditionCD;
import org.example.demo.model.SwimmingCoach;
//import org.example.demo.model.ToDo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		try {

			@SuppressWarnings("resource")
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			/*
			 * Coach theCoach=context.getBean("theCoach",Coach.class);
			 * System.out.println(theCoach.getDailyworkOut()); Coach
			 * theCoach2=context.getBean("theCoach",Coach.class);
			 * System.out.println(theCoach==theCoach2);
			 * 
			 * 
			 * InternationalCD cd = context.getBean("theCD", InternationalCD.class);
			 * System.out.println(cd.getDetails()); cd.setCdId(101);
			 * cd.setCdName("Godzila"); cd.setLanguage("Russian");
			 * System.out.println(cd.getDetails()); SpecialEditionCD
			 * cd1=context.getBean("theCD1",SpecialEditionCD.class);
			 * System.out.println(cd1.getDetails());
			 */
			/*
			 * Coach tempCoach= context.getBean("theCoach",CricketCoach.class);
			 * System.out.println(tempCoach.getDailyworkOut());
			 * System.out.println(tempCoach.getDailyFortune());
			 */
			/*
			  Customer customer=context.getBean("theCustomer",Customer.class);
			  System.out.println(customer);
			 
			/*ToDo myTodo=context.getBean("a",ToDo.class);
			myTodo.setTodoId(UUID.randomUUID().toString());
			myTodo.setTodoName("compile");
			myTodo.setCompleted(true);
			System.out.println(myTodo);*/
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			e.printStackTrace();
		}
	}
}

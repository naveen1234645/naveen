package org.example.hibernate_demo_crud.factory;

import java.util.Properties;

import org.example.hibernate_demo_crud.model.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class MySessionFactory {

	private static MySessionFactory mySessionFactory;
	private SessionFactory sessionFactory;

	private Properties properties=null;
	private MySessionFactory() {
		properties=new Properties();
		properties.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		properties.put("hibernate.connection.password", "root");
		properties.put("hibernate.connection.url", "jdbc:mysql://localhost: 3306/hr");
		properties.put("hibernate.connection.username","root");
		properties.put("hibernate.default_schema", "hr");

	}

	public static MySessionFactory createMySessionFactory() {
		if (mySessionFactory == null) {
			mySessionFactory = new MySessionFactory();
		}
		return mySessionFactory;
	}

	public SessionFactory getSessionFactory()
	{
		sessionFactory=new Configuration().addProperties(properties).addAnnotatedClass(Employee.class).buildSessionFactory();
		return sessionFactory;
	}


}
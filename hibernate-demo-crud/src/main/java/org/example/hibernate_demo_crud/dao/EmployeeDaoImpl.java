package org.example.hibernate_demo_crud.dao;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;


import javax.persistence.Query;

import org.example.hibernate_demo_crud.factory.MySessionFactory;
import org.example.hibernate_demo_crud.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EmployeeDaoImpl implements EmployeeDao {

	private MySessionFactory mySessionFactory;
	private SessionFactory sessionFactory;
	private Session session;

	private static Scanner scanner=new Scanner(System.in);

	{
		mySessionFactory=MySessionFactory.createMySessionFactory();
		sessionFactory=mySessionFactory.getSessionFactory();
		session=sessionFactory.openSession();
	}

	@Override
	public Employee createEmployee(Employee employee) {
		session=sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(employee);
		session.getTransaction().commit();
		return employee;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> displayAllEmployee() {
		session=sessionFactory.openSession();

		Query query=session.createQuery("select E from Employee E");
		return query.getResultList();

	}
	@Override
	public Employee getemployeeById(Integer id) {
		session=sessionFactory.openSession();
		return session.get(Employee.class, id);
	}

	@Override
	public Employee updateEmployee(Integer id) {
		// TODO Auto-generated method stub
		return null;
		session=sessionFactory.openSession();
		Employee tempEmployee= session.get(Employee.class, id);
		if(tempEmployee ==null)
		{

			throw new EmployeeNotFoundException("employee not found.");

		}
		System.out.print("First Name: ");
		String firstName=scanner.next();
		System.out.print("Last Name: ");
		String lastName=scanner.next();
		System.out.print("Email: ");
		String email=scanner.next();
		tempEmployee.setFirstName(firstName);
		tempEmployee.setLastName(lastName);
		tempEmployee.setEmail(email);
		session.getTransaction().begin();
		session.merge(tempEmployee);
		session.getTransaction().commit();
		return tempEmployee;

	}

	@Override
	public void deleteEmployee(Integer id) {
		// TODO Auto-generated method stub
		session=sessionFactory.openSession();
		Employee delEmployee= session.get(Employee.class, id);
		if(delEmployee ==null)
		{

			throw new EmployeeNotFoundException("employee not found.");

		}
		session.getTransaction().begin();
		session.remove(delEmployee);
		session.getTransaction().commit();


	}
	
}

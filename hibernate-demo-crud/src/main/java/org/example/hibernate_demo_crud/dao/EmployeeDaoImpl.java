package org.example.hibernate_demo_crud.dao;

import java.util.List;

import javax.persistence.Query;

import org.example.hibernate_demo_crud.factory.MySessionFactory;
import org.example.hibernate_demo_crud.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EmployeeDaoImpl implements EmployeeDao {

	private MySessionFactory mySessionFactory;
	private SessionFactory sessionFactory;
	private Session session;


	{
		mySessionFactory=MySessionFactory.createMySessionFactory();
		sessionFactory=mySessionFactory.getSessionFactory();
	}

	@Override
	public Employee createEmployee(Employee employee) {
		session=sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(employee);
		session.getTransaction().commit();
		return employee;
	}


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
	}

	@Override
	public void deleteEmployee(Integer id) {
		// TODO Auto-generated method stub

	}

}

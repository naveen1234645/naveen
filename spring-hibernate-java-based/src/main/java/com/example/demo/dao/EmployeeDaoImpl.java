package com.example.demo.dao;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.EmployeeNotFoundException;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.ui.EmployeeResponseModel;

@Repository
@EnableTransactionManagement
@Transactional
public class EmployeeDaoImpl implements EmployeeDao{

	private static Scanner scanner=new Scanner(System.in);
	private SessionFactory sessionFactory;

	private ModelMapper modelMapper;
	
	@Autowired
	public EmployeeDaoImpl(SessionFactory sessionFactory, ModelMapper modelMapper) {
		super();
		this.sessionFactory = sessionFactory;
		this.modelMapper = modelMapper;
	}
	
	
	@Override
	//@Transactional
	public EmployeeResponseModel createEmployee(EmployeeDto employeeDetails) {
		// TODO Auto-generated method stub
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	
		Employee employee = modelMapper.map(employeeDetails, Employee.class);
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.getTransaction().begin();
		currentSession.persist(employee);
		currentSession.getTransaction().commit();
		EmployeeResponseModel model = modelMapper.map(employee, EmployeeResponseModel.class);
	return model;
	}


	@Override
	public List<EmployeeResponseModel> displayAllEmployee() {
		// TODO Auto-generated method stub
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		Session currentSession = sessionFactory.openSession();

		Query query=currentSession.createQuery("select E from Employee E");
		@SuppressWarnings("unchecked")
		List<Employee> list=query.getResultList();
		Iterator<Employee> i=list.iterator();
		List<EmployeeResponseModel> list1=new ArrayList<EmployeeResponseModel>();
		while(i.hasNext())
		{
			list1.add(modelMapper.map(i.next(), EmployeeResponseModel.class));		}
		return list1;
	
		
	
	
	}


	@Override
	public EmployeeResponseModel updatebyId(String employeeId ) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.openSession();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Query query=currentSession.createQuery("select E from Employee E where employeeId=:empId").setString("empId",employeeId);
         List<Employee> list=query.getResultList();
		
		Employee employee=list.get(0);
		
		if(employee ==null)
		{
			
			throw new EmployeeNotFoundException("employee not found.");
			
		}
		
		System.out.print("First Name: ");
		String firstName=scanner.next();
		System.out.print("Last Name: ");
		String lastName=scanner.next();
		System.out.print("Email: ");
		String email=scanner.next();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setEmail(email);
		
		currentSession.merge(employee);
		
		
		EmployeeResponseModel model = modelMapper.map(employee, EmployeeResponseModel.class);
		return model;
		
	}


	@Override
	public void deleteEmployee(String employeeId) {
		// TODO Auto-generated method stub
		/*
		 * Session currentSession = sessionFactory.openSession();
		 * modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT)
		 * ; EmployeeResponseModel delEmployee = findByEmployeeId(employeeId); Employee
		 * model = modelMapper.map(delEmployee, Employee.class); if(model ==null) {
		 * 
		 * throw new EmployeeNotFoundException("employee not found.");
		 * 
		 * } currentSession.getTransaction().begin(); currentSession.remove(model);
		 * currentSession.getTransaction().commit(); delEmployee =
		 * modelMapper.map(model, EmployeeResponseModel.class);
		 */
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("select E from Employee E where employeeId=:empId").setString("empId",employeeId);
		@SuppressWarnings("unchecked")
		List<Employee> list=query.getResultList();
		
		Employee employee=list.get(0);
		session.remove(employee);
		
		//EmployeeResponseModel model = modelMapper.map(employee, EmployeeResponseModel.class);
		System.out.println("Successfully Deleted book");
		
		
		
	}


	@Override
	public EmployeeResponseModel findByEmployeeId(String employeeId) {
		// TODO Auto-generated method stub
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Session currentSession = sessionFactory.openSession();
		Query query=currentSession.createQuery("SELECT E FROM Employee E WHERE E.employeeId=:empId").setString("empId", employeeId);
		List<Employee> list=query.getResultList();
		if(list.isEmpty())
		{
			
			return null;
		}
		else
		{
			Iterator<Employee> i=list.iterator();
			List<EmployeeResponseModel> list1=new ArrayList<EmployeeResponseModel>();
			while(i.hasNext())
			{
				list1.add(modelMapper.map(i.next(), EmployeeResponseModel.class));		
			}
			EmployeeResponseModel model=list1.get(0);
			return model;
		}
		
	}
	
	
		
	}
	


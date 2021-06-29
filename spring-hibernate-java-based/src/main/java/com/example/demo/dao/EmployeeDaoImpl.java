package com.example.demo.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.ui.EmployeeResponseModel;

@Repository

public class EmployeeDaoImpl implements EmployeeDao {

	private SessionFactory sessionFactory;

	private ModelMapper modelMapper;

	@Autowired
	public EmployeeDaoImpl(SessionFactory sessionFactory, ModelMapper modelMapper) {
		super();
		this.sessionFactory = sessionFactory;
		this.modelMapper = modelMapper;
	}

	@Override
	@Transactional
	public EmployeeResponseModel createEmployee(EmployeeDto employeeDetails) {
		// TODO Auto-generated method stub
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Employee employee = modelMapper.map(employeeDetails, Employee.class);
		Session currentSession = sessionFactory.openSession();
	currentSession.getTransaction().begin();
		currentSession.persist(employee);
		currentSession.getTransaction().commit();
		EmployeeResponseModel model = modelMapper.map(employee, EmployeeResponseModel.class);
		return model;
	}

	@Override
	public List<EmployeeResponseModel> displayAllEmployee() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Session currentSession = sessionFactory.openSession();
		Query query=currentSession.createQuery("SELECT E FROM Employee E");
		@SuppressWarnings("unchecked")
		List<Employee> list=query.getResultList();
		Iterator<Employee> i=list.iterator();
		List<EmployeeResponseModel> list1=new ArrayList<EmployeeResponseModel>();
		while(i.hasNext())
		{
			list1.add(modelMapper.map(i.next(), EmployeeResponseModel.class));		}
		return list1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public EmployeeResponseModel findByEmployeeId(String employeeId) {
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
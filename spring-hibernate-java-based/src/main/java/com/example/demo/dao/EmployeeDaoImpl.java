package com.example.demo.dao;


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
@EnableTransactionManagement
public class EmployeeDaoImpl implements EmployeeDao {

	private SessionFactory sessionFactory;

	private ModelMapper modelMapper;

	@Autowired
	public EmployeeDaoImpl(SessionFactory sessionFactory, ModelMapper modelMapper) {
		super();
		this.sessionFactory = sessionFactory;
		this.modelMapper = modelMapper;
	}

	//@Override
	@Transactional
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

}
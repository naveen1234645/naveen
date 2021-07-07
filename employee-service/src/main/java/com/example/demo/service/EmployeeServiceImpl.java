package com.example.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDao employeeDao;
	
	
    @Autowired
	public EmployeeServiceImpl(EmployeeDao employeeDao) {
	
		this.employeeDao = employeeDao;
	}

	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		String[] str=UUID.randomUUID().toString().split("-");
		employee.setEmployeeId(str[0]);
		return employeeDao.createEmployee(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeDao.getAllEmployee();
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		return employeeDao.getEmployeeById(id);
	}

	@Override
	public Employee getByEmployeeId(String id) {
		// TODO Auto-generated method stub
		return employeeDao.getByEmployeeId(id);
	}

	@Override
	public List<Employee> getByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return employeeDao.getByFirstName(firstName);
	}

	@Override
	public List<Employee> getByLastName(String lastName) {
		// TODO Auto-generated method stub
		return employeeDao.getByLastName(lastName);
	}

	@Override
	public Employee updateByEmployeeId(String employeeId, Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.updateByEmployeeId(employeeId, employee);
	}

	@Override
	public String deleteByEmployeeId(String employeeId) {
		// TODO Auto-generated method stub
		return employeeDao.deleteByEmployeeId(employeeId);
	}


	
}
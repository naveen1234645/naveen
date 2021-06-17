package org.example.service;

import java.sql.SQLException;
import java.util.List;

import org.example.dao.EmployeeDao;
import org.example.dao.EmployeeDaoImpl;
import org.example.model.Employee;

public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDao employeeDao;


	public EmployeeServiceImpl() throws SQLException {
		employeeDao=new EmployeeDaoImpl();
	}

	@Override
	public Employee createEmployee(Employee employee) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() throws SQLException {
		// TODO Auto-generated method stub
		return employeeDao.getAllEmployees();
	}

}
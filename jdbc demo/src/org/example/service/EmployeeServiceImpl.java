package org.example.service;
import java.sql.SQLException;
import java.util.List;

import org.example.dao.EmployeeDao;
import org.example.dao.EmployeeDaoImpl;
import org.example.dao.EmployeeNotFoundException;
import org.example.model.Employee;

public class EmployeeServiceImpl implements EmployeeService{
	private EmployeeDao employeeDao;
	
	
	public EmployeeServiceImpl() throws SQLException {
		employeeDao=new EmployeeDaoImpl();
	}
	@Override
	public Employee createEmployee(Employee employee) throws SQLException {
		// TODO Auto-generated method stub
		return employeeDao.createEmployee(employee);
	}
	@Override
	public List<Employee> getAllEmployees() throws SQLException {
		// TODO Auto-generated method stub
		return employeeDao.getAllEmployees();
	}
	@Override
	public List<Employee> findById(Integer id) throws SQLException {
		
		return employeeDao.findById(id);
	}

	@Override
	public Employee updateEmployee(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		Employee employee=null;
		try {
			employee=employeeDao.updateEmployee(id);
		} catch (SQLException | EmployeeNotFoundException e) {
			System.err.println(e.getMessage());
		}
		return employee;
	}

}
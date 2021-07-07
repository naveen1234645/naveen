package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Employee;

@Repository
@EnableTransactionManagement
public class EmployeeDaoImpl implements EmployeeDao {

	private EntityManager entityManager;
	
	
	@Autowired
	public EmployeeDaoImpl(EntityManager entityManager) {
		
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		entityManager.persist(employee);
		return employee;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("SELECT E FROM Employee E",Employee.class);
		
		return query.getResultList();
	}

	@Override
	@Transactional
	public Employee getEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		Employee employee1 = entityManager.find(Employee.class, id);
		if(employee1==null)
		{
			throw new EmployeeNotFoundException("Employee of this ID does not exist :(");
		}
		return employee1;
	}

	@Override
	public Employee getByEmployeeId(String id) {
		// TODO Auto-generated method stub
		Query query=entityManager.createQuery("SELECT E FROM Employee E WHERE E.employeeId=:eId",Employee.class);
		query.setParameter("eId", id);
		@SuppressWarnings("unchecked")
		List<Employee> list=query.getResultList();
		if(list.isEmpty())
		{
			throw new EmployeeNotFoundException("Employee with given id not found.");
		}
		return list.get(0);
	}

	@Override
	public List<Employee> getByFirstName(String firstName) {
		// TODO Auto-generated method stub
		Query query=entityManager.createQuery("SELECT E FROM Employee E WHERE E.firstName=:fName",Employee.class);
		query.setParameter("fName",firstName);
		@SuppressWarnings("unchecked")
		List<Employee> list=query.getResultList();
		if(list.isEmpty())
		{
			throw new EmployeeNotFoundException("Employee with given first name not found.");
		}
		return list;
	}

	@Override
	public List<Employee> getByLastName(String lastName) {
		// TODO Auto-generated method stub
		Query query=entityManager.createQuery("SELECT E FROM Employee E WHERE E.lastName=:lName",Employee.class);
		query.setParameter("lName",lastName);
		@SuppressWarnings("unchecked")
		List<Employee> list=query.getResultList();
		if(list.isEmpty())
		{
			throw new EmployeeNotFoundException("Employee with given last name not found.");
		}
		return list;
	}

	@Override
	@Transactional
	public Employee updateByEmployeeId(String employeeId, Employee employee) {
		// TODO Auto-generated method stub
		Employee employee1 = getByEmployeeId(employeeId);
		employee1.setFirstName(employee.getFirstName());
		employee1.setLastName(employee.getLastName());
		employee1.setEmail(employee.getEmail());
		//employee1.setIsActive(employee.getIsActive());
		
		return employee1;
	}

	@Override
	@Transactional
	public String deleteByEmployeeId(String employeeId) {
		// TODO Auto-generated method stub
		Employee employee = getByEmployeeId(employeeId);
		entityManager.remove(employee);
		return "deleted sucessfully";
	}

}
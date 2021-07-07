  
package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import com.example.demo.ui.EmployeeErrorResponse;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class EmployeeController {

	private EmployeeService employeeService;
    
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		
		this.employeeService = employeeService;
	}
	
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleEmployeeNotFoundException(EmployeeNotFoundException e){
		EmployeeErrorResponse response = new EmployeeErrorResponse();
		response.setMessage(e.getMessage());
		response.setStatusCode(HttpStatus.NOT_FOUND.value());
		response.setErrorReportingTime(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}
	
	
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse>  handleTypeMisMatchedException(Exception e){
		EmployeeErrorResponse response = new EmployeeErrorResponse();
		response.setMessage(e.getMessage());
		response.setStatusCode(HttpStatus.NOT_FOUND.value());
		response.setErrorReportingTime(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}
	
	@GetMapping("/api/employee")
	public ResponseEntity<List<Employee>> getAllEmployee()
	{
		log.info("within get all method");
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAllEmployee());
	}
	
	@PostMapping("/api/employee")
	public ResponseEntity<Employee> createANewEmployee(@RequestBody Employee employee)
	{
		log.info("within post mapping");
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employee));
		
	}
	
	@GetMapping("/api/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id)
	{
		log.info("within get by id");
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeById(id));
		
	}
	
	@GetMapping("/api/employee/find/{employeeId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("employeeId") String employeeId)
	{
		log.info("within get by employeeId");
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getByEmployeeId(employeeId));
	}
	
	
	@GetMapping("/api/employee/find1/{firstName}")
	public ResponseEntity<List<Employee>> getByFirstName(@PathVariable("firstName") String firstName)
	{
		log.info("within get by first name");
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getByFirstName(firstName));
	}
	
	@GetMapping("/api/employee/find2/{lastName}")
	public ResponseEntity<List<Employee>> getByLastName(@PathVariable("lastName") String lastName)
	{
		log.info("within get by last name");
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getByLastName(lastName));
	}
	
	@PutMapping("/api/employee/update/{employeeId}")
	public ResponseEntity<Employee> updateBookByBookId(@PathVariable("employeeId") String employeeId,@RequestBody Employee employee)
	{
		log.info("within put mapping");
		Employee employee2 = employeeService.updateByEmployeeId(employeeId, employee);
		return ResponseEntity.status(HttpStatus.OK).body(employee2);
	}
	
	@DeleteMapping("/api/employee/delete/{employeeId}")
	public ResponseEntity<String> deleteByEmployeeId(@PathVariable("employeeId") String employeeId)
	{
		log.info("within delete by employee_id");
		return ResponseEntity.ok(employeeService.deleteByEmployeeId(employeeId));
	}
	
	
	
}

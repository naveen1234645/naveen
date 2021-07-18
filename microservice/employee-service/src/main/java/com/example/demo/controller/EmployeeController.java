package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController

public class EmployeeController {
	
	private EmployeeService employeeService;
	private Environment environment;
	@Autowired
	public EmployeeController(EmployeeService employeeService, Environment environment) {

		this.employeeService = employeeService;
		this.environment = environment;
	}
	
	@GetMapping
	public ResponseEntity<StringBuilder> getStatus()
	{
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append("application employee-service is up");
		stringBuilder.append("on port: "+environment.getProperty("local.server.port"));
		return ResponseEntity.ok(stringBuilder);
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employee));
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees()
	{
		return ResponseEntity.ok(employeeService.displayEmployee());
		
	}

}
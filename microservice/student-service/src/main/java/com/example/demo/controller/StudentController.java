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

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController

public class StudentController {
	
	private StudentService studentService;
	private Environment environment;
	@Autowired
	public StudentController(StudentService studentService, Environment environment) {

		this.studentService = studentService;
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
	
	@PostMapping("/students")
	public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(student));
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudentss()
	{
		return ResponseEntity.ok(studentService.displayStudent());
		
	}

}
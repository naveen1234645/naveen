package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentService {

	
	public Student createStudent(Student student);
	
	public List<Student> displayStudent();
}
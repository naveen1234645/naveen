package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao;

	@Autowired
	public StudentServiceImpl(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public Student createStudent(Student student) {
		
		return studentDao.save(student);
	}

	

	@Override
	public List<Student> displayStudent() {
		// TODO Auto-generated method stub
		return studentDao.findAll();
	}

}
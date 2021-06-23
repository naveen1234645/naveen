package org.example.hibernate_set_crud.service;




import java.util.List;

import org.example.hibernate_set_crud.dao.StudentDao;
import org.example.hibernate_set_crud.dao.StudentDaoImpl;
import org.example.hibernate_set_crud.model.Student;

public class StudentServiceImpl implements StudentService{
	StudentDao studentDao=null;
	{
		studentDao=new StudentDaoImpl();
	}

	@Override
	public Student createStudent(Student student) {
		return studentDao.createStudent(student);
	}

	@Override
	public List<Student> displayAllStudents() {
		// TODO Auto-generated method stub
		return studentDao.displayAllStudents();
	}

	@Override
	public Student findById(int id) {
		// TODO Auto-generated method stub
		return studentDao.findById(id);
	}

	@Override
	public void deleteById(int id) {
		studentDao.deleteById(id);		
	}

	@Override
	public Student updateById(int id) {
		// TODO Auto-generated method stub
		return studentDao.updateById(id);
	}

}
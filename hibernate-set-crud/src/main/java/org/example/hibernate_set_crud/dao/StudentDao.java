package org.example.hibernate_set_crud.dao;



import java.util.List;

import org.example.hibernate_set_crud.model.Student;

public interface StudentDao {

	public Student createStudent(Student student);

	public List<Student> displayAllStudents();

	public Student findById(int id);

	public void deleteById(int id);

	public Student updateById(int id);

}

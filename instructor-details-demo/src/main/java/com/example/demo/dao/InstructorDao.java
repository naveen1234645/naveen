package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Instructor;

@Repository
public interface InstructorDao extends CrudRepository<Instructor, Integer> {
	

}

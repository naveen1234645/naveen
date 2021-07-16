package com.example.demo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Assignee;
@Repository
public interface AssigneeRepository extends MongoRepository<Assignee, Integer>{
	@Query
	public Assignee getAssigneeByAssigneeName(String assigneeName); 
}
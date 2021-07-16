package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Assignee;
import com.example.demo.repo.AssigneeRepository;
@Service
public class AssigneeServiceImpl implements AssigneeService{
	private AssigneeRepository assigneeRepo;
	@Autowired
	public AssigneeServiceImpl(AssigneeRepository assigneeRepo) {
		
		this.assigneeRepo = assigneeRepo;
	}

	@Override
	public Assignee createAssignee(Assignee assignee) {
		
		return assigneeRepo.save(assignee);
	}

	@Override
	public List<Assignee> getAllAssignee() {
		
		return assigneeRepo.findAll();
	}

	@Override
	public Assignee getAssigneeByAssigneeName(String assigneeName) {
		
		return assigneeRepo.getAssigneeByAssigneeName(assigneeName);
	}
	
}

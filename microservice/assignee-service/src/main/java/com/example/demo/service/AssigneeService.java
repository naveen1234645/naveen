package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Assignee;

public interface AssigneeService {
	public Assignee createAssignee(Assignee assignee);
	public List<Assignee> getAllAssignee();
	public Assignee getAssigneeByAssigneeName(String assigneeName);
}
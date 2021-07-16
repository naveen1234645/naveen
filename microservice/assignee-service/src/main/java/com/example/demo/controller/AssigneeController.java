package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Assignee;
import com.example.demo.service.AssigneeService;

@RestController
public class AssigneeController {
	private AssigneeService assigneeService;
	@Autowired
	public AssigneeController(AssigneeService assigneeService) {
		
		this.assigneeService = assigneeService;
	}
	
	@PostMapping("/assignee")
	public ResponseEntity<Assignee> createAssignee(@RequestBody Assignee assignee)
	{
		return new ResponseEntity<Assignee>(assigneeService.createAssignee(assignee),HttpStatus.CREATED);
	}
	
	@GetMapping("/assignee")
	public ResponseEntity<List<Assignee>> getAllAssignee()
	{
		return new ResponseEntity<List<Assignee>>(assigneeService.getAllAssignee(),HttpStatus.OK);
	}
	@GetMapping("/assignee/assigneeName")
	public ResponseEntity<Assignee> getAssigneeByAssigneeName(@PathVariable("assigneeName") String assigneeName)
	{
		return new ResponseEntity<Assignee>(assigneeService.getAssigneeByAssigneeName(assigneeName),HttpStatus.OK);
	}
}
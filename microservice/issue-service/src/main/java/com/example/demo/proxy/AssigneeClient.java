package com.example.demo.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Assignee;

@FeignClient(name="assignee-service")
public interface AssigneeClient {
	 	
	@GetMapping("/assignee/assigneeName")
	public Assignee getAssigneeByAssigneeName(@PathVariable("assigneeName") String assigneeName);
	
	@GetMapping("/assignee")
	public List<Assignee> getAllAssignee();

}
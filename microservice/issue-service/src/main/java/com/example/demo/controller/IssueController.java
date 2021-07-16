package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Assignee;
import com.example.demo.model.Issue;
import com.example.demo.model.Severity;
import com.example.demo.proxy.AssigneeClient;
import com.example.demo.service.IssueService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class IssueController {
	private IssueService issueService;
	private Environment environment;
	private AssigneeClient assigneeClient;

	@Autowired
	public IssueController(IssueService issueService, Environment environment, AssigneeClient assigneeClient) {
		
		this.issueService = issueService;
		this.environment = environment;
		this.assigneeClient = assigneeClient;
	}

	@GetMapping
	public ResponseEntity<String> getStatus()
	{
		return new ResponseEntity<String>("issue service is up and running on port: "+environment.getProperty("local.server.port"),HttpStatus.OK);
	}
	
	@PostMapping("/issues")
	public ResponseEntity<Issue> createIssue(@RequestBody Issue issue) throws Exception
	{
		Assignee assignee=assigneeClient.getAssigneeByAssigneeName(issue.getAssignee());
		if(assignee.getIsAvailable()==false)
		{
			throw new Exception();
		}
		return new ResponseEntity<Issue>(issueService.createIssue(issue),HttpStatus.CREATED);
	}
	
	@GetMapping("/issues")
	public ResponseEntity<List<Issue>> getAllIssues()
	{
		return new ResponseEntity<List<Issue>>(issueService.getAllIssues(),HttpStatus.OK);
	}
	
	@GetMapping("/issues/assignees")
	@HystrixCommand(fallbackMethod = "assigneeFallBack")
	public ResponseEntity<List<Assignee>> getAllAssignee()
	{
		List<Assignee> list=new ArrayList<Assignee>();
		list=assigneeClient.getAllAssignee();
		System.out.println(list);
		return ResponseEntity.ok(list);
	}
	
	public ResponseEntity<List<Assignee>> assigneeFallBack()
	{
		List<Assignee> list=new ArrayList<Assignee>();
		list.add(0,null);
		return ResponseEntity.ok(list);

	}
	
	@GetMapping("/issues/{id}")
	public ResponseEntity<Issue> findIssueById(@PathVariable("id") String id)
	{
		return new ResponseEntity<Issue>(issueService.findIssueById(id),HttpStatus.OK);
	}
	@PutMapping("/issues/{id}")
	public ResponseEntity<Issue> updateIssue(@PathVariable("id") String id,@RequestBody Issue issue)
	{
		return new ResponseEntity<Issue>(issueService.updateIssue(id, issue),HttpStatus.OK);
	}
	
	@DeleteMapping("/issues/{id}")
	public ResponseEntity<String> deleteIssue(@PathVariable("id") String id)
	{
		return new ResponseEntity<String>(issueService.deleteIssue(id),HttpStatus.OK);
	}

	@GetMapping("/issues/find/{assignee}")
	public ResponseEntity<Issue> findIssueByAssignee(@PathVariable("assignee") String assignee)
	{
		return new ResponseEntity<Issue>(issueService.findIssueByAssignee(assignee),HttpStatus.OK);
	}
	@GetMapping("/findsevere/{severity}")
	public ResponseEntity<List<Issue>> findIssueByAssignee(@PathVariable("severity") Severity severity)
	{
		return new ResponseEntity<List<Issue>>(issueService.findIssueBySeverity(severity),HttpStatus.OK);
	}
	@GetMapping("/issues/finddesc/{desc}")
	public ResponseEntity<Issue> findIssueByDescription(@PathVariable("desc") String desc)
	{
		return new ResponseEntity<Issue>(issueService.findIssueByDescription(desc),HttpStatus.OK);
	}
	@PutMapping("/issues/assignee/{assignee}")
	public ResponseEntity<Issue> updateIssueByAssignee(@PathVariable("assignee") String assignee,@RequestBody Issue issue)
	{
		return new ResponseEntity<Issue>(issueService.updateIssueByAssignee(assignee, issue),HttpStatus.OK);
	}
	@PutMapping("/issues/desc/{desc}")
	public ResponseEntity<Issue> updateIssueByDescription(@PathVariable("desc") String desc,@RequestBody Issue issue)
	{
		return new ResponseEntity<Issue>(issueService.updateIssueByDescription(desc, issue),HttpStatus.OK);
	}
	@DeleteMapping("/issues/assignee/{assignee}")
	public ResponseEntity<String> deleteIssueByAssignee(@PathVariable("assignee") String assignee)
	{
		return new ResponseEntity<String>(issueService.deleteIssueByAssignee(assignee),HttpStatus.OK);
	}
	
	@DeleteMapping("/issues/desc/{desc}")
	public ResponseEntity<String> deleteIssueByDescription(@PathVariable("desc") String desc)
	{
		return new ResponseEntity<String>(issueService.deleteIssueByDescription(desc),HttpStatus.OK);
	}
	
	
}
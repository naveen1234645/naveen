package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.IssueNotFoundException;
import com.example.demo.model.Issue;
import com.example.demo.repo.IssueRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class IssueServiceImpl implements IssueService {

	private IssueRepository issueRepository;
	
	@Autowired
	public IssueServiceImpl(IssueRepository issueRepository) {
		this.issueRepository = issueRepository;
	}

	@Override
	public Issue createNewIssue(Issue issue) {
		log.info("within create issue service");
		return issueRepository.insert(issue);
		
	}

	@Override
	public List<Issue> displayAllIssues() {
		log.info("within display issue service");
		return issueRepository.findAll();
	}

	@Override
	public Optional<Issue> findIssueById(String id) {
		Optional<Issue> issue=issueRepository.findById(id);
		if(issue.isEmpty())
		{
			throw new IssueNotFoundException("isue with the given id not found.");
		}
		
		return issue;
	}

	@Override
	public Optional<Issue> findIssueByDescription(String description) {
		Optional<Issue> issue= issueRepository.findByDescription(description);
		if(issue.isEmpty())
		{
			throw new IssueNotFoundException("isue with the given description not found.");
		}
		
		return issue;
	}

	
	
	@Override
	public Issue updateIssue(String id, Issue issue) {
		Optional<Issue> issue1=issueRepository.findById(id);
		if(issue1.isEmpty())
		{
			throw new IssueNotFoundException("isue with the given id not found.");
		}
		Issue tempIssue=issue1.get();
		tempIssue.setSeverity(issue.getSeverity());
		tempIssue.setAssignee(issue.getAssignee());
		tempIssue.setDescription(issue.getAssignee());
		issueRepository.save(tempIssue);
		log.info("updated");
		return tempIssue;
	}

	@Override
	public Issue removeIssue(String id) {
		Optional<Issue> issue1=issueRepository.findById(id);
		if(issue1.isEmpty())
		{
			throw new IssueNotFoundException("isue with the given id not found.");
		}
		Issue tempIssue=issue1.get();
		issueRepository.delete(tempIssue);
		return tempIssue;
	}

	
	
}
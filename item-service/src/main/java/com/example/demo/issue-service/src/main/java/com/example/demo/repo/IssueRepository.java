package com.example.demo.repo;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Issue;
@Repository
public interface IssueRepository extends MongoRepository<Issue, String>{
	@Query
	public List<Issue> findByAssignee(String assignee);

	public Optional<Issue> findByDescription(String description);

}
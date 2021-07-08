package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.InstructorDetail;
import com.example.demo.service.InstructorDetailService;

@RestController
@RequestMapping("/api")
public class InstructorDetailController {
	
	private InstructorDetailService instructorDetailService;
	@Autowired
	public InstructorDetailController(InstructorDetailService instructorDetailService) {
	
		this.instructorDetailService = instructorDetailService;
	}
	@PostMapping("/instructordetails")
	private ResponseEntity<InstructorDetail> create_NewInstructorDetail(@RequestBody InstructorDetail instructorDetail)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(instructorDetailService.createInstructorDetails(instructorDetail));
	}

	
}
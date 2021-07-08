package com.example.demo.controller;
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
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;
import com.example.demo.service.InstructorService;


@RestController
@RequestMapping("/api")
public class InstructorController {
	private InstructorService instructorService;
	public InstructorController(InstructorService instructorService) {
		super();
		this.instructorService = instructorService;
	}
	

	@PostMapping("/instructors")
	public ResponseEntity<Instructor> createInstructor(@RequestBody Instructor instructor)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(instructorService.createInstructor(instructor));
	}
	@GetMapping("/instructors")
	public ResponseEntity<?> getAllIstructor()
	{
		return ResponseEntity.ok(instructorService.getAllInstructor());
	}
	@PutMapping("instructors/update/{Id}")
	public ResponseEntity<Instructor> updateInstructorById(@PathVariable("Id")Integer Id,@RequestBody Instructor instructor,@RequestBody InstructorDetail instructorDetail)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(instructorService.createInstructor(instructor));
	}
	@DeleteMapping("instructors/delete/{Id}")
	public ResponseEntity<String> deleteInstructorById(@PathVariable("Id") Integer Id)
	{
		return ResponseEntity.ok(instructorService.deleteById(Id));
	}

}
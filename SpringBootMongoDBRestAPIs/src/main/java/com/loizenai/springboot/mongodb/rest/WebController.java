package com.loizenai.springboot.mongodb.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loizenai.springboot.mongodb.model.Customer;
import com.loizenai.springboot.mongodb.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class WebController {
	
	@Autowired
	CustomerService customerService;

	@PostMapping("/create")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
		return ResponseEntity.status(HttpStatus.CREATED).body(customerService.saveCustomer(customer));
	}
	

}
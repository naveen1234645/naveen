package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.OrderEntity;
import com.example.demo.service.OrderService;

@RestController
public class OrderController {

	private Environment environment;
	private OrderService orderService;

	@Autowired
	public OrderController(Environment environment,OrderService orderService) {
		this.environment = environment;
		this.orderService=orderService;
	}

	@GetMapping
	public ResponseEntity<String> getStatus() {
		return ResponseEntity.ok("app running and up on port" + environment.getProperty("local.server.port"));
	}
	@PostMapping("/orders")
	public ResponseEntity<OrderEntity> createOrder(@RequestBody OrderEntity orderEntity)
	{
		return new ResponseEntity<OrderEntity>(orderService.createOrder(orderEntity),HttpStatus.CREATED);
	}
	
	@GetMapping("/orders")
	public ResponseEntity<List<OrderEntity>> displayOrders()
	{
		return ResponseEntity.ok(orderService.displayOrders());
	}
}
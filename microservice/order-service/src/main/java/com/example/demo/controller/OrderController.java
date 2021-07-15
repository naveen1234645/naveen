package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Item;
import com.example.demo.model.OrderEntity;
import com.example.demo.service.OrderService;

@RestController
public class OrderController {

	private Environment environment;
	private OrderService orderService;
	private RestTemplate restTemplate;

	@Autowired
	public OrderController(Environment environment,OrderService orderService,RestTemplate restTemplate) {
		this.environment = environment;
		this.orderService=orderService;
		this.restTemplate=restTemplate;
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
	
	@GetMapping("/orders/items")
	public ResponseEntity<List<Item>> getItemFromItemService()
	{
		String uri="http://localhost:8088/item-service/items";
		@SuppressWarnings("unchecked")
		List<Item> items=restTemplate.getForObject(uri, List.class);
		return ResponseEntity.ok(items);
	}
	@GetMapping("/orders/items/{itemNumber}")
	public ResponseEntity<Item> getItemfromItemServiceByItemNumber(@PathVariable("itemNumber") String itemNumber)
	{
		String uri="http://localhost:8088/item-service//items/"+itemNumber;
		Item item =restTemplate.getForObject(uri, Item.class);
		if(item==null)
		{
			System.out.println("not found");
		}
		return ResponseEntity.ok(item);
		
	}
}
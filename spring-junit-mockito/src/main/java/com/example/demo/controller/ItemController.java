package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Item;
import com.example.demo.service.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	private ItemService service;
	
	@GetMapping("/items")
	public List<Item> retrieveAllItems() {
		return service.calculateTotalValue();
	}

}
package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.ItemRepository;
import com.example.demo.entity.Item;

@Component
public class ItemService {

	@Autowired
	private ItemRepository repository;

	public List<Item> calculateTotalValue() {

		List<Item> items = repository.findAll();

		items.stream().forEach((item) -> {
			item.setValue(item.getPrice() * item.getQuantity());
		});

		return items;
	}
	
	public void insertItem() {
		
	}

}

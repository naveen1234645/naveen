package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.ItemRepository;
import com.example.demo.entity.Item;

@SpringBootApplication
public class SpringJunitMockitoApplication implements CommandLineRunner {

	private ItemRepository itemRepository;
	
	@Autowired
	public SpringJunitMockitoApplication(ItemRepository itemRepository) {
		super();
		this.itemRepository = itemRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringJunitMockitoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		itemRepository.save(new Item(10001, "Chocolates", 25, 2));
		itemRepository.save(new Item(10002, "Biscuits", 50, 2));
		itemRepository.save(new Item(10003, "Pens", 25, 3));
		itemRepository.save(new Item(10004, "Pencils", 25, 2));
		
	}

}
package com.example.demo;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.ItemDao;
import com.example.demo.model.Item;

@SpringBootApplication
@EnableDiscoveryClient
public class ItemServiceApplication implements CommandLineRunner {

	private ItemDao itemDao;
	@Autowired
	public ItemServiceApplication(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	public static void main(String[] args) {
		SpringApplication.run(ItemServiceApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		
		itemDao.save(new Item(UUID.randomUUID().toString(),"Item-1", 100.0, true));
		itemDao.save(new Item(UUID.randomUUID().toString(),"Item-2", 101.0, false));
		itemDao.save(new Item(UUID.randomUUID().toString(),"Item-3", 100.2, true));
		itemDao.save(new Item(UUID.randomUUID().toString(),"Item-4", 100.3, true));
		itemDao.save(new Item(UUID.randomUUID().toString(),"Item-5", 100.4, false));
		itemDao.save(new Item(UUID.randomUUID().toString(),"Item-6", 100.5, true));
	}

}
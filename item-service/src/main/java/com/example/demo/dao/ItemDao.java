package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Item;

@Repository
public interface ItemDao extends JpaRepository<Item, Integer>{
	
	@Query
	public Item findByItemNumber(String itemNumber);
	@Query
	public List<Item> findByItemName(String itemName);
	

}
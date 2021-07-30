package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Item;
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

}
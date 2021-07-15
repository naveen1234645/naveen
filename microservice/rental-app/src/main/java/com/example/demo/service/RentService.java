package com.example.demo.service;

import java.util.List;

import com.example.demo.model.RentEntity;

public interface RentService {
	
	public RentEntity createRent(RentEntity rentEntity);
	
	public List<RentEntity> displayAllRent();

}
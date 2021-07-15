package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.RentRepository;
import com.example.demo.model.RentEntity;
@Service
public class RentServiceImpl implements RentService{
	private RentRepository rentRepository;
	
	
	public RentServiceImpl(RentRepository rentRepository) {
		this.rentRepository = rentRepository;
	}

	@Override
	public RentEntity createRent(RentEntity rentEntity) {
		
		return rentRepository.save(rentEntity);
	}

	@Override
	public List<RentEntity> displayAllRent() {
		return rentRepository.findAll();
	}

}
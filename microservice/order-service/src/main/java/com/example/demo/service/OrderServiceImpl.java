package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.OrderRepository;
import com.example.demo.model.OrderEntity;
@Service
public class OrderServiceImpl implements OrderService {

	private OrderRepository orderRepository;
	
	@Autowired
	public OrderServiceImpl(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public OrderEntity createOrder(OrderEntity orderEntity) {
	
		orderRepository.insert(orderEntity);
		return orderEntity;
	}

	@Override
	public List<OrderEntity> displayOrders() {
		
		return orderRepository.findAll();
	}

}
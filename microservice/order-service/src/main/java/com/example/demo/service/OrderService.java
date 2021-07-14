package com.example.demo.service;

import java.util.List;

import com.example.demo.model.OrderEntity;

public interface OrderService {
	
	public OrderEntity createOrder(OrderEntity orderEntity);
	
	public List<OrderEntity> displayOrders();

}

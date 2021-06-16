package comm.example.demo.service;



import java.util.ArrayList;
import java.util.List;

import comm.example.demo.model.Order;

public class OrderServiceImpl implements OrderService {
	private List<Order> orders=null;

	{
		orders=new ArrayList<Order>();
	}
	@Override
	public Order createOrder(Order order) {
		// TODO Auto-generated method stub
		orders.add(order);
		return order;
	}

	@Override
	public List<Order> getAllOrder() {
		// TODO Auto-generated method stub
		return orders;
	}

}

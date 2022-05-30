package com.capg.service;

import java.util.List;

import com.capg.entity.Order;

public interface OrderService {
	
	List<Order> getOrders();
	
	Order updateOrder(Integer orderid,Order order);
	

	

}

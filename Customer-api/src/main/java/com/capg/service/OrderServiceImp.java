package com.capg.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Order;
import com.capg.repositiory.OrderRepositiory;
@Service

public class OrderServiceImp implements OrderService{
	
	@Autowired
	private OrderRepositiory orderRepositiory;
	

	@Override
	public List<Order> getOrders() {
	
		return orderRepositiory.findAll();
	}


	@Override
	@Transactional
	public Order updateOrder(Integer orderid, Order order) {
		
	   Order orders =orderRepositiory.findById(orderid).get();
	   
		orders.setOrderName(order.getOrderName());
		orders.setQuantity(order.getQuantity());
		orders.setPrice(order.getPrice());
	
		return orderRepositiory.save(orders);
	}





	


	
	
	

}

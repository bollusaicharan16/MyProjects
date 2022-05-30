package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.Order;
import com.capg.service.OrderService;

@RestController
@RequestMapping("/Order")
public class OrderController {

	@Autowired
	private OrderService orderservice;
	
	@GetMapping("/getallorders")
	public List<Order> getOrders(){
		return orderservice.getOrders();
	}
	
	
	@PutMapping("/updateorder/{id}")
	public Order updateorder(@PathVariable("id") Integer orderid,@RequestBody Order order) {
		
		return orderservice.updateOrder(orderid, order);
	}
	
	
}

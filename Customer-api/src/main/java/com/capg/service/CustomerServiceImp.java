package com.capg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dto.CustomerDTO;
import com.capg.entity.Customer;
import com.capg.entity.Order;
import com.capg.exception.CustomerNotFoundException;
import com.capg.repositiory.CustomerRepositiory;

@Service
public class CustomerServiceImp implements CustomerService{
	
	@Autowired
    private CustomerRepositiory customerRepositiory;
    

	@Override
	public CustomerDTO createCustomer(CustomerDTO customerDTO) {
		Customer customer = new Customer(customerDTO);
		
		List<Order> orders=customerDTO.getOrders();
		List<Order> order=new ArrayList<Order>();
		for(Order o:orders) {
			o.setCustomer(customer);
			order.add(o);
			
		}

		
		return new CustomerDTO(customerRepositiory.save(customer));
	}

	@Override
	@Transactional
	public CustomerDTO updateCustomer(Integer id, CustomerDTO customerDTO) {
		Customer customer=customerRepositiory.findById(id).orElseThrow(() -> new CustomerNotFoundException("***Customer Not Found*** :"+id));
	
		customer.setFirstName(customerDTO.getFirstName());
		customer.setLastName(customerDTO.getLastName());
		customer.setSalary(customerDTO.getSalary());
		
	return new CustomerDTO(customer);
	}

	@Override
	@Transactional
	public CustomerDTO partiallyUpdate(Integer id, Double salary) {
		Customer customer=customerRepositiory.findById(id).orElseThrow(() -> new CustomerNotFoundException("***Customer Not Found*** :"+id));
		customer.setSalary(salary);
		return new CustomerDTO(customer);
	}

	@Override
	public void Delete(Integer id) {
		Customer customer=customerRepositiory.findById(id).orElseThrow(() -> new CustomerNotFoundException("***Customer Not Found*** :"+id));
		customerRepositiory.delete(customer);
	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerRepositiory.findAll();
	}

	@Override
	public CustomerDTO getCustomer(Integer id) {
	Customer customer=customerRepositiory.findById(id).orElseThrow(() -> new CustomerNotFoundException("***Customer Not Found*** :"+id));
		return new CustomerDTO(customer);
	}

    @Override
	public List<CustomerDTO> getCustomer(String email) {
    	List<Customer> customer=customerRepositiory.findbyemail(email);
	return customer.stream().map(CustomerDTO::new).collect(Collectors.toList());
	}

	@Override
	public List<CustomerDTO> searchCustomer(String query) {
		List<Customer> customers=customerRepositiory.searchCustomer(query);
		return customers.stream().map(CustomerDTO::new).collect(Collectors.toList());
	}

	@Override
	public void DeleteAll() {
		customerRepositiory.deleteAll();
	}

	

	
}

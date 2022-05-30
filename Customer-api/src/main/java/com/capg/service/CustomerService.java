package com.capg.service;

import java.util.List;

import com.capg.dto.CustomerDTO;
import com.capg.entity.Customer;

public interface CustomerService {

	CustomerDTO createCustomer(CustomerDTO customerDTO);
	CustomerDTO updateCustomer(Integer id,CustomerDTO customerDTO);
	CustomerDTO partiallyUpdate(Integer id,Double salary);
	void Delete(Integer id);
	void DeleteAll();
	List<Customer> getAllCustomer();
	CustomerDTO getCustomer(Integer id);
	List<CustomerDTO> getCustomer(String email);
	List<CustomerDTO> searchCustomer(String query);
	
	
	
}

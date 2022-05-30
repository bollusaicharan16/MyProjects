package com.capg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capg.dto.CustomerDTO;
import com.capg.entity.Customer;
import com.capg.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService; 
	
	
	@PostMapping("/save")
	public CustomerDTO saveCustomer(@Valid@RequestBody CustomerDTO customerDTO) {
		return customerService.createCustomer(customerDTO);
	}
	
	@GetMapping("/getall")
	public List<Customer> getCustomer(){
		return customerService.getAllCustomer();
	}
	
	@GetMapping("/get/{id}")
	public CustomerDTO getCustomerById(@PathVariable Integer id) {
		return customerService.getCustomer(id);
	}
	
	@GetMapping("/getemail")
	public List<CustomerDTO> getCustomerByEmail(@RequestParam("email") String email) {
		return customerService.getCustomer(email);
		
	}
	
	@GetMapping("/search")
	public List<CustomerDTO> searchCustomer(@RequestParam("query") String query ){
		return customerService.searchCustomer(query);
	}
	

	
	@PutMapping("/update/{id}")
	public ResponseEntity<CustomerDTO> updateCustomers(@PathVariable Integer id,@RequestBody CustomerDTO customerDTO) {
		return new ResponseEntity<CustomerDTO>(customerService.updateCustomer(id, customerDTO),HttpStatus.OK);
	}
	@PatchMapping("/partialupdate/{id}/{salary}")
	public ResponseEntity<CustomerDTO> partialupdate(@PathVariable Integer id,@PathVariable Double salary){
		return new ResponseEntity<CustomerDTO>(customerService.partiallyUpdate(id, salary),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{id}")
		public String delete(@PathVariable Integer id) {
		customerService.Delete(id);
		return "Customer with ID "+id+" was Deleted";
			
		}
	
	@DeleteMapping("/deleteAll")
	public String deletAll() {
		customerService.DeleteAll();
		return "All Customers are Deleted Successfully";
	}
	
	
	
	
}

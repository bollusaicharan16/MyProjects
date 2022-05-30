package com.capg.repositiory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.dto.CustomerDTO;
import com.capg.entity.Customer;

@Repository
public interface CustomerRepositiory extends JpaRepository<Customer, Integer>{
	
	
	
	
	@Query("SELECT c FROM Customer c WHERE c.email= :email")
	List<Customer> findbyemail(String email);

	@Query("SELECT c FROM Customer c WHERE c.firstName= :query "+"OR c.lastName= :query")
	List<Customer> searchCustomer(String query);
	
}

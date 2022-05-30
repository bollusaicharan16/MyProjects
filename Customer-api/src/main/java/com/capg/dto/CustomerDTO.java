package com.capg.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.capg.entity.Address;
import com.capg.entity.Customer;
import com.capg.entity.Order;

public class CustomerDTO {
	
	private Integer id;
	
	@NotBlank(message = "Customer FirstName Can't Be Blank or Null")
	@Size(min=2)
	private String firstName;
	
	@NotBlank(message = "Customer LastName Can't Be Blank or Null")
	@Size(min=2)
	private String lastName;
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
	private String email;
	@NotNull
	@Min(1000)
	private Double salary;
	
	@Valid
	private List<Address> address;
    @Valid
	private List<Order> orders;
	
	public CustomerDTO(Customer customer) {
		this.id=customer.getId();
		this.firstName=customer.getFirstName();
		this.lastName=customer.getLastName();
		this.email=customer.getEmail();
		this.salary=customer.getSalary();
		this.address=customer.getAddress();
		this.orders=customer.getOrders();
		
	}
	public CustomerDTO() {
		
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "CustomerDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", salary=" + salary + ", address=" + address + ", orders=" + orders + "]";
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	
	}

	

}

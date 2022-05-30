package com.capg.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.capg.dto.CustomerDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Customer_tbl")
public class Customer {
	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Customer_id")
	private Integer id;
	
	@Column(name="Customer_firstName")
	private String firstName;
	@Column(name="Customer_lastName")
	private String lastName;
	@Column(name="Customer_email")
	private String email;
	@Column(name="Customer_Salary")
	private Double salary;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="address_Customer_id",referencedColumnName = "Customer_id")
	private List<Address> address=new ArrayList<>();

	
	@OneToMany(mappedBy = "customer",cascade =CascadeType.ALL)
	private List<Order> orders=new ArrayList<>();
	
	public Customer() {
		
	}




	public Customer(Integer id, String firstName, String lastName, String email, Double salary, List<Address> address,
			List<Order> orders) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.salary = salary;
		this.address = address;
		this.orders = orders;
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


	public Customer(CustomerDTO customerDTO) {
		this.id=customerDTO.getId();
		this.firstName=customerDTO.getFirstName();
		this.lastName=customerDTO.getLastName();
		this.email=customerDTO.getEmail();
		this.salary=customerDTO.getSalary();
		this.address=customerDTO.getAddress();
		this.orders=customerDTO.getOrders();
		
		
	}




	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", salary=" + salary + ", address=" + address + ", orders=" + orders + "]";
	}


	

}

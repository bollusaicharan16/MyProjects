package com.capg.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="Order_tbl")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Order_Id")
	private Integer orderId;
	
	@Column(name="Order_OrderName")
	@NotBlank(message = "orderName couldn't be empty or null")
	private String orderName;
	@Column(name="Order_OrderQuantity")
	
	@NotNull(message = "quantity can't be Null or empty")
	private Integer quantity;
	@Column(name="Order_OrderPrice")
	@NotNull(message = "price can't be Empty or Null")
	private Long price;
	

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_Customer_id",referencedColumnName = "Customer_id")
	private Customer customer;


	public Order() {
		
	}


	public Integer getOrderId() {
		return orderId;
	}


	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}


	public String getOrderName() {
		return orderName;
	}


	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Long getPrice() {
		return price;
	}
	
	public Customer getCustomer() {
		
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public void setPrice(Long price) {
		this.price = price;
	}



	public Order(Integer orderId, @NotBlank(message = "orderName couldn't be empty or null") String orderName,
			@NotNull(message = "quantity can't be Null or empty") Integer quantity,
			@NotNull(message = "price can't be Empty or Null") Long price) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
		this.quantity = quantity;
		this.price = price;
		
	}


	


	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderName=" + orderName + ", quantity=" + quantity + ", price=" + price
				+ "]";
	}
	
	
}
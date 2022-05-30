package com.capg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="Address_tbl")
public class Address {
	@Id
	@Column(name="address_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "address_pin")

	@NotNull
	private Integer pin;
  
	@SuppressWarnings("deprecation")
	@Column(name = "address_city")
	@NotBlank(message = "city couldn't Blank")
	private String city;
 
	@SuppressWarnings("deprecation")
	@Column(name="address_state")
	@NotBlank(message = "state couldn't Blank")
	private String state;
	

	
	public Address() {
		
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getPin() {
		return pin;
	}



	public void setPin(Integer pin) {
		this.pin = pin;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public Address(Integer id, Integer pin, String city, String state) {
		super();
		this.id = id;
		this.pin = pin;
		this.city = city;
		this.state = state;
	}



	@Override
	public String toString() {
		return "Address [id=" + id + ", pin=" + pin + ", city=" + city + ", state=" + state + "]";
	}




}

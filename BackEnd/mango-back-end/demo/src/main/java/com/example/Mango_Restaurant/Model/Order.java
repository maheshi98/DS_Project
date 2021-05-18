package com.example.Mango_Restaurant.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Order_Details")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int OrderID;
	
	@Column(name ="email")
	private String email;
	
	@Column(name ="address")
	private String address;
	
	@Column(name ="Landmark")
	private String Landmark;
	
	@Column(name ="zip")
	private String zip;
	
	@Column(name ="name")
	private String name;
	
	@Column(name ="number")
	private String number;
	
	@Column(name ="Description")
	private String Description;
	
	public Order(){
		
	}
	
	
	public Order(String email, String address, String landmark, String zip, String name, String number,
			String description) {
		super();
		this.email = email;
		this.address = address;
		Landmark = landmark;
		this.zip = zip;
		this.name = name;
		this.number = number;
		Description = description;
	}


	public int getOrderID() {
		return OrderID;
	}


	public void setOrderID(int orderID) {
		OrderID = orderID;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getLandmark() {
		return Landmark;
	}


	public void setLandmark(String landmark) {
		Landmark = landmark;
	}


	public String getZip() {
		return zip;
	}


	public void setZip(String zip) {
		this.zip = zip;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}

	

}

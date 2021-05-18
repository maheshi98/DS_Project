package com.example.Mango_Restaurant.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ShoppingCart")
public class ShoppingCart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartID;
	
	@Column(name ="UserId")
	private String UserId;
	
	
	@Column(name ="ProductName")
	private String ProductName;
	
	@Column(name ="UnitPrice")
	private int UnitPrice;
	
	@Column(name ="Quantity")
	private String Quantity;
	
	@Column(name ="productID")
	private int productID;
	
	
	

	public ShoppingCart() {
		super();
	}



	public ShoppingCart(int cartID, String userId, String productName, int unitPrice, String quantity, int productID) {
		super();
		this.cartID = cartID;
		UserId = userId;
		ProductName = productName;
		UnitPrice = unitPrice;
		Quantity = quantity;
		this.productID = productID;
	}

	


	public String getUserId() {
		return UserId;
	}




	public void setUserId(String userId) {
		UserId = userId;
	}




	public int getProductID() {
		return productID;
	}



	public void setProductID(int productID) {
		this.productID = productID;
	}



	public int getCartID() {
		return cartID;
	}


	public void setCartID(int cartID) {
		this.cartID = cartID;
	}


	public String getProductName() {
		return ProductName;
	}


	public void setProductName(String productName) {
		ProductName = productName;
	}


	public int getUnitPrice() {
		return UnitPrice;
	}


	public void setUnitPrice(int unitPrice) {
		UnitPrice = unitPrice;
	}


	public String getQuantity() {
		return Quantity;
	}


	public void setQuantity(String quantity) {
		Quantity = quantity;
	}
	
	

}

package com.example.Mango_Restaurant.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "itemLine")
public class ItemLine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "Name")
	private String pName;
	
	@Column(name = "Quantity")
	private int qty;
	
	@Column(name = "Amount")
	private float amount;
	
	@Column(name = "Price")
	private float price;
	
	@Column(name = "Total_Amount")
	private float tAmount;
	
	@Column(name = "Pay")
	private float pay;
	
	@Column(name = "Balance")
	private float balance;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float gettAmount() {
		return tAmount;
	}
	public void settAmount(float tAmount) {
		this.tAmount = tAmount;
	}
	public float getPay() {
		return pay;
	}
	public void setPay(float pay) {
		this.pay = pay;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
}
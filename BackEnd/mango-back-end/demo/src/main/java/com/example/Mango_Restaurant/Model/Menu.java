package com.example.Mango_Restaurant.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menuDetails")
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "imgURL")
	private String imgURL;
	
	@Column(name = "foodName")
	private String foodName;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "price")
	private int price;
	
	public Menu() {
		
	}
	
	public Menu(String category,String imgURL, String foodName, String description, int price) {
		super();
		this.category = category;
		this.imgURL = imgURL;
		this.foodName = foodName;
		this.description = description;
		this.price = price;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImgURL() {
		return imgURL;
	}
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}

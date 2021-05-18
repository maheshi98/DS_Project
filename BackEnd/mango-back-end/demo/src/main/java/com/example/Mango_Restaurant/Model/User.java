package com.example.Mango_Restaurant.Model;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import com.sun.istack.NotNull;
//import org.springframework.data.mongodb.core.mapping.Document

@Entity
@Table(name = "User")
public class User {
	
	 @Id
	 @NotNull
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String email;
	 
	@Column(name = "fname")
	private String fName;
	
	@Column(name = "lname")
	private String lName;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "other_details")
	private String otherDetails;
	
	@Column(name = "role")
	private Integer role;

	 public User() {
		
	}

	public User(String email, String fName, String lName, String username, String gender, String password,
			String otherDetails, Integer role) {
		super();
		this.email = email;
		this.fName = fName;
		this.lName = lName;
		this.username = username;
		this.gender = gender;
		this.password = password;
		this.otherDetails = otherDetails;
		this.role = role;
	}

	
	
	
	
	public String getfName() {
		return fName;
	}
	
	public void setfName(String fName) {
		this.fName = fName;
	}
	
	public String getlName() {
		return lName;
	}
	
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getOtherDetails() {
		return otherDetails;
	}
	
	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}
	
	
	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}




}

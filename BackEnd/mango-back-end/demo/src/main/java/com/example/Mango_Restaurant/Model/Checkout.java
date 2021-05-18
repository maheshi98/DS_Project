/**
 * 
 */
package com.example.Mango_Restaurant.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CheckoutDetails")
public class Checkout {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//@Column(name = "Email_Address")
	//private String email;
	
	//@Column(name = "Address_1")
	//private String address1;
	
	//@Column(name = "Address_2")
	//private String address2;
	
	
	
	//@Column(name = "Zip_Code")
	//private int zipcode;
	
	@Column(name = "Type")
	private String paymentType;
	
	@Column(name = "Card_Number")
	private String cardNo;
	
	@Column(name = "CVV")
	private String cvv;
	
	@Column(name = "Date")
	private String city;
	
	
	public Checkout() {
		
	}
	
	public Checkout(String paymentType,String cardNo, String cVV , String city) {
		super();
		//this.email = email;
		//this.address1 = address1;
		//this.address2 = address2;
		
		//this.zipcode = zipcode;
		this.paymentType = paymentType;
		this.cardNo = cardNo;
		this.cvv = cVV;
		this.city = city;
		
	}
	
	public long getId() {
		return id;
	}
	public void setCid(long id) {
		this.id = id;
	}
	//public String getEmail() {
	//	return email;
	//}
	//public void setEmail(String email) {
	//	this.email = email;
	//}
	//public String getAddress1() {
	//	return address1;
	//}
	//public void setAddress1(String address1) {
	//	this.address1 = address1;
	//}
	//public String getAddress2() {
	//	return address2;
	//}
	//public void setAddress2(String address2) {
	//	this.address2 = address2;
	//}
	
	//public int getZipcode() {
	//	return zipcode;
	//}
	//public void setZipcode(int zipcode) {
	//	this.zipcode = zipcode;
	//}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getCVV() {
		return cvv;
	}
	public void setCVV(String cVV) {
		this.cvv = cVV;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
		
}


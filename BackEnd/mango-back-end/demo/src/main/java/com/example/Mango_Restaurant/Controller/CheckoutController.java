

package com.example.Mango_Restaurant.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Mango_Restaurant.Exception.ResourceNotFound;
import com.example.Mango_Restaurant.Model.Checkout;
import com.example.Mango_Restaurant.Repository.CheckoutRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class CheckoutController {
	
	@Autowired
	private CheckoutRepository checkoutRepository;

	//get checkout details
	
	@GetMapping("/CheckoutDetails")
	public List<Checkout> getAllCheckoutDetails(){
		return checkoutRepository.findAll();
	}
	
	@PostMapping("/CheckoutDetails")
	public Checkout createCheckout(@RequestBody Checkout checkoutdetails) {
		return checkoutRepository.save(checkoutdetails);
	}
	
	
	@GetMapping("/CheckoutDetails/{id}")
	public ResponseEntity<Checkout> getCheckoutDetailsById(@PathVariable Long id) {
		
		Checkout checkout = checkoutRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFound("Checkout not exist with id: " + id));
		
		return ResponseEntity.ok(checkout);
	}  
	
	@PutMapping("/CheckoutDetails/{id}")
	public ResponseEntity<Checkout> updateCheckoutDetails(@PathVariable Long id, @RequestBody Checkout checkoutDetails){
		
		Checkout checkout = checkoutRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFound("Checkout not exist with id: " + id));
		
		//checkout.setEmail(checkoutDetails.getEmail());
		//checkout.setAddress1(checkoutDetails.getAddress1());
		//checkout.setAddress2(checkoutDetails.getAddress2());
		
		//checkout.setZipcode(checkoutDetails.getZipcode());
		checkout.setPaymentType(checkoutDetails.getPaymentType());
		checkout.setCardNo(checkoutDetails.getCardNo());
		checkout.setCVV(checkoutDetails.getCVV());
		checkout.setCity(checkoutDetails.getCity());
		
		Checkout updatedCheckout = checkoutRepository.save(checkout);
		return ResponseEntity.ok(updatedCheckout);
	}
	
	@DeleteMapping("/CheckoutDetails/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCheckout(@PathVariable Long id){
		Checkout checkout = checkoutRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFound("CheckoutDetails not exist with id:" +id));
		
			checkoutRepository.delete(checkout);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
	
	}	
	
}
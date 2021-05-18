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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Mango_Restaurant.Exception.ResourceNotFound;
import com.example.Mango_Restaurant.Model.Order;
import com.example.Mango_Restaurant.Repository.OrderRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class OrderController {

	@Autowired
	private OrderRepository orderrepository;
	
	// get all details
	@GetMapping("/checkout")
	public List <Order> getAllDetails(){
		return orderrepository.findAll();
		}
	
	// create order rest api
	@PostMapping("/checkout")
	public Order createOrder(@RequestBody Order order) {
		return orderrepository.save(order);
		
	}
	
	//getEmployee by ID
	@GetMapping("/checkout/{id}")
	public ResponseEntity <Order>	getOrderbyID(@PathVariable int id) {
		
		Order order = orderrepository.findById(id).orElseThrow(()-> new ResourceNotFound("not found"));
		
		return ResponseEntity.ok(order);
	}
	
	//delete order by ID
//	@DeleteMapping("/orderdet/{OrderID}")
	@RequestMapping(method = RequestMethod.DELETE, value = "/orderdet/{OrderID}")
	public ResponseEntity <Map<String , Boolean>> deleteOrder(@PathVariable int OrderID){
		System.out.println("Here");
		Order order = orderrepository.findById(OrderID).orElseThrow(()-> new ResourceNotFound("not found"));
		
		orderrepository.delete(order);
		Map<String , Boolean> response = new HashMap<>();
		response.put("deleted" , Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}

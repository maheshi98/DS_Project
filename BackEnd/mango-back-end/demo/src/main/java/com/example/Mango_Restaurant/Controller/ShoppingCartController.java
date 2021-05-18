package com.example.Mango_Restaurant.Controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Mango_Restaurant.Exception.ResourceNotFound;
import com.example.Mango_Restaurant.Model.Order;
import com.example.Mango_Restaurant.Model.ShoppingCart;
import com.example.Mango_Restaurant.Repository.ShoppingCartRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class ShoppingCartController {
	
	@Autowired
	private ShoppingCartRepository shoppingCartRepo;
	
	// get all details
		@GetMapping("/shopping")
		public List <ShoppingCart> getShoppingcartdet(){
			return shoppingCartRepo.findAll();
			}
		
		@GetMapping("/shopping/user/{userId}")
		public List <ShoppingCart> getShoppingcartdetForUser(@PathVariable String userId){
			List<ShoppingCart> listForUser = new ArrayList<>();
			List<ShoppingCart> list = shoppingCartRepo.findAll();
			
			for(ShoppingCart cart : list) {
				if(userId.equals(cart.getUserId())) {
					listForUser.add(cart);
				}
			}
			
			return listForUser;
			}
		
		// create order rest api
		@PostMapping("/shopping")
		public ShoppingCart createShoppingcart(@RequestBody ShoppingCart shoppingcart) {
			return shoppingCartRepo.save(shoppingcart);
			
		}
		
		@GetMapping("/shopping/{cartID}")
		public ResponseEntity <ShoppingCart>	getShoppingCartbyID(@PathVariable String cartID) {
			
			ShoppingCart shoppingcart = shoppingCartRepo.findById(Integer.parseInt(cartID)).orElseThrow(()-> new ResourceNotFound("not found"));
			
			return ResponseEntity.ok(shoppingcart);
		}
		
		@DeleteMapping("/shopping/{cartID}")
		public List<ShoppingCart>  deleteOrder(@PathVariable String cartID){
			System.out.println("Here");
			ShoppingCart shoppincart = shoppingCartRepo.findById(Integer.parseInt(cartID)).orElseThrow(()-> new ResourceNotFound("not found"));
			
			shoppingCartRepo.delete(shoppincart);
			return shoppingCartRepo.findAll();
		}
		//update shoppingcart
		@PutMapping("/shopping/{cartID}/{quantity}")
		public  List<ShoppingCart> updateshoppingcart(@PathVariable String cartID , @PathVariable String quantity){
			
			ShoppingCart shoppincart = shoppingCartRepo.findById(Integer.parseInt(cartID)).orElseThrow(() -> new ResourceNotFound("not found" +cartID));
			shoppincart.setQuantity(quantity);
			
			ShoppingCart updateshoppingcart = shoppingCartRepo.save(shoppincart);
			return shoppingCartRepo.findAll();
		}

}

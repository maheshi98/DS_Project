package com.example.Mango_Restaurant.Controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Mango_Restaurant.Exception.ResourceNotFound;
import com.example.Mango_Restaurant.Model.User;
import com.example.Mango_Restaurant.Repository.UserRepository;


//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")


public class UserController {

	@Autowired
	private UserRepository userRepo;
	
	
	//get all detail List
	@GetMapping("/users")
	public List<User> getAllCustomers(){
		//userRepo.count();
		return userRepo.findAll();
		
	}
	
	//get details by id
	@GetMapping("users/{id}")
	public ResponseEntity<User> getCustomerById(@PathVariable String id){
		User user = null;
		user = userRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFound("User not exist with id :" + id));
		
		return ResponseEntity.ok(user);	
	}
	
	//save customer details
	@PostMapping("/users")
	public User addCustomer(@RequestBody User user) {
		return userRepo.save(user);
		
	}
	
	//update user details
	@RequestMapping(method = {RequestMethod.PUT,RequestMethod.POST} ,value="/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable String id,@RequestBody User userDetails){
		User user = userRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFound("User not exist with id :"));
		
		user.setEmail(userDetails.getEmail());
		user.setfName(userDetails.getfName());
		user.setlName(userDetails.getlName());
		user.setGender(userDetails.getGender());
		user.setUsername(userDetails.getUsername());
		user.setOtherDetails(userDetails.getOtherDetails());
		

		User updatedUser = userRepo.save(user);
		return ResponseEntity.ok(updatedUser);		
		
	}
	
	//get by id
	@GetMapping("opUsers/{id}")
	public Optional<User> findUserDetails(@PathVariable String id){
        return (Optional<User>) userRepo.findById(id);
    }
	
	//delete customer by ID
	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
	public ResponseEntity <Map<String , Boolean>> deleteCustomer(@PathVariable String id){
		//System.out.println("Here");
		User user = userRepo.findById(id).orElseThrow(()-> new ResourceNotFound("not found"));
		
		userRepo.delete(user);
		Map<String , Boolean> response = new HashMap<>();
		response.put("deleted" , Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}

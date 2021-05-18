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
import com.example.Mango_Restaurant.Model.Menu;

@CrossOrigin(origins = "http://localhost:3000" )
@RestController
@RequestMapping("/api/v1/")
public class MenuController {
	
	@Autowired
	private MenuRepository menuRepository;
	
	//get all menu details
	
	@GetMapping("/menuDetails")
	public List<Menu> getAllMenuDetails(){
		return menuRepository.findAll();
	}
	//create menu details rest api
	
	@PostMapping("/menuDetails")
	public Menu createMenu(@RequestBody Menu menu) {
		return menuRepository.save(menu);
	}	
	// get Menu by id api
	
	@GetMapping("/menuDetails/{id}")
	public ResponseEntity<Menu> getMenuById(@PathVariable Long id){
		Menu menu = menuRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Menu not exist with id:" +id));
		return ResponseEntity.ok(menu);
	}
	
	//update menu rest api
	@PutMapping("/menuDetails/{id}")  
	public ResponseEntity<Menu> updateMenu(@PathVariable Long id,@RequestBody Menu menuDetails){
		Menu menu = menuRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFound("Menu not exist with id:" +id));
		
		menu.setImgURL(menuDetails.getImgURL());
		menu.setCategory(menuDetails.getCategory());
		menu.setFoodName(menuDetails.getFoodName());
		menu.setDescription(menuDetails.getDescription());
		menu.setPrice(menuDetails.getPrice());
		
		Menu updateMenu = menuRepository.save(menu);
		
		return ResponseEntity.ok(updateMenu);
	}
	
	//delete menu rest api
	@DeleteMapping("/menuDetails/{id}")
	public ResponseEntity<Map<String,Boolean>>deleteMenu(@PathVariable Long id){
		Menu menu = menuRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFound("Menu not exist with id:" +id));
		
		menuRepository.delete(menu);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
		
	}

}

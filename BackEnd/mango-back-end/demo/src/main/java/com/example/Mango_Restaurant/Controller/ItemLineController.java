package com.example.Mango_Restaurant.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Mango_Restaurant.Exception.ResourceNotFound;
import com.example.Mango_Restaurant.Model.ItemLine;
import com.example.Mango_Restaurant.Repository.ItemLineRepository;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ItemLineController {

	@Autowired
	private ItemLineRepository itemlineRepository;
	
//	private ItemLineDAO itemLineService;

	//get checkout details
	
//	@GetMapping("/ItemLineDetails")
//	public List<ItemLine> getAllCheckoutDetails(){
//		return itemLineService.findAll();
//	}
	
//	@GetMapping("/ItemLineDetails/{id}")
//	public ItemLine get(@PathVariable int id) {
//		return itemLineService.get(id);
//	}
//	
	@GetMapping("/ItemLineDetails/{id}")
	public ResponseEntity<ItemLine> getItemDetailsById(@PathVariable Long id) {
		
		ItemLine itemLine = itemlineRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFound("Item not exist with id: " + id));
		
		return ResponseEntity.ok(itemLine);
	}  
	
}

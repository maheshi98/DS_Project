package com.example.Mango_Restaurant.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound  extends RuntimeException{

	private static final long SerialVersionUID = 1L;
	
	public ResourceNotFound(String message) {
		super(message);
		
	}
}

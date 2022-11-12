package com.foodwala.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodwala.exception.LoginException;
import com.foodwala.model.LoginDTO;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class LoginController {

	
	
	
	@PostMapping("/login")
	public ResponseEntity<String> logIntoAccount(@RequestBody LoginDTO dto) throws LoginException{
		
		
		
		
		
		
	}
	
	
	
	
	@PostMapping("/logout/{key}")
	public ResponseEntity<String> logOutFromAccount(@PathVariable("key") String key) throws LoginException{
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}

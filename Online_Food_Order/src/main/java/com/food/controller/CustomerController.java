package com.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.food.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

}

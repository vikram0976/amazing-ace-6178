package com.foodwala.service;

import org.springframework.stereotype.Repository;

import com.foodwala.model.Customer;

@Repository
public interface CustomerService {
	
	public Customer addCustomer(Customer customer);

}

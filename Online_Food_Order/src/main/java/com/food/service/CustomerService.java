package com.food.service;

import java.util.List;
import com.food.model.Customer;
import com.food.model.UserDTO;
import com.food.model.UserType;

public interface CustomerService {
	
	
	public Customer addCustomer(Customer customer);
	
	public List<Customer> getAllCustomer();
	
	public String removeCustomer(UserDTO custDTO);

	public Customer findByNameAndPassword(String userName, String password);


}

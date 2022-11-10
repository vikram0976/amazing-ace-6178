package com.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.model.Customer;
import com.food.model.UserDTO;
import com.food.model.UserType;
import com.food.repository.CustomerRepo;

@Service
public class CustomerImpl implements CustomerService {
	
	@Autowired
	private CustomerRepo custRepo;

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeCustomer(UserDTO custDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findByNameAndPassword(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}

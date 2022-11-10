package com.food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.model.FoodCart;
import com.food.model.UserType;
import com.food.repository.FoodCartRepo;

@Service
public class FoodCartImpl implements FoodCartService{

	@Autowired
	private FoodCartRepo foodCartRepo;

	@Override
	public FoodCart addToCart(Integer itemId, Integer itemQty, UserType userType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeFromCart(Integer itemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FoodCart cartItems() {
		// TODO Auto-generated method stub
		return null;
	}


	
}

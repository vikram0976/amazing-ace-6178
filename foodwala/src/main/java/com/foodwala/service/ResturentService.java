package com.foodwala.service;

import com.foodwala.exception.ResturentException;
import com.foodwala.model.Restaurant;

public interface ResturentService {
	
	public Restaurant SaveResturent(Restaurant resturent);
//	public Restaurant UpdateResturent(Restaurant resturent)throws ResturentException;
//	public String DelateResturent(Restaurant resturent)throws ResturentException;
	public Restaurant viewResturent(Restaurant resturent)throws Exception;
	Restaurant UpdateResturent(Restaurant resturent, String key) throws ResturentException;
	String DelateResturent(Restaurant resturent, String key) throws ResturentException;

}

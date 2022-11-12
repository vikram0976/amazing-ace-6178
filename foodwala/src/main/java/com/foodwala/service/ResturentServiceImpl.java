package com.foodwala.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodwala.exception.ResturentException;
import com.foodwala.model.Address;
import com.foodwala.model.Item;
import com.foodwala.model.Restaurant;
import com.foodwala.repository.AddressRepo;
import com.foodwala.repository.ItemRepo;
import com.foodwala.repository.ResturentRespo;

import net.bytebuddy.implementation.bytecode.Throw;
@Service
public class ResturentServiceImpl implements ResturentService{
	@Autowired
	public ResturentRespo rservice;
	
	@Autowired
	public ItemRepo itemrepo;
	
	@Autowired
	public AddressRepo aRepo;

	@Override
	public Restaurant SaveResturent(Restaurant resturent) {
		
		List<Item> items=resturent.getItemList();
		
		for(Item item:items) {
			item.getRestaurants().add(resturent);
		}
		
		return rservice.save(resturent);
	}

	@Override
	public Restaurant UpdateResturent(Restaurant resturent) throws ResturentException {
		
		Optional<Restaurant> resturentobj=rservice.findById(resturent.getRestaurantId());
		
		Restaurant updateResturent=resturentobj.get(); 
		
	
		
	         List<Item> items=resturent.getItemList();	
	         
	     	if(updateResturent==null) {
				throw new ResturentException("Resturent not found by the given Id");
			}
		     

			List<Item> item=resturent.getItemList();
			for(Item item1:items) {
				item1.getRestaurants().add(resturent);
			}
			
		
					
		    return rservice.save(resturent);
	}

	@Override
	public String DelateResturent(Restaurant resturent) throws ResturentException {
		


		
		
	    
	    
		Optional<Restaurant> DResturent=rservice.findById(resturent.getRestaurantId());
	
		
		
		 
		
		 
		 if(DResturent.isPresent()) {
			 Restaurant drest=DResturent.get();
			
			 rservice.deleteById(resturent.getRestaurantId());
				
				return "Resturent delation sussfully";
			
			 
		 }
		 throw new ResturentException("resturent not present in database which you want to remove");
		 
	}

	@Override
	public Restaurant viewResturent(Restaurant resturent) throws Exception {
		
		Optional<Restaurant> res=rservice.findById(resturent.getRestaurantId());
		
		Restaurant rest=res.get();
		if(rest!=null) {
			return rest;
		}
		
		throw new Exception("Resturent not found given by id");
	}
}

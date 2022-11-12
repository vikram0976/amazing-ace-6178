package com.foodwala.repository;


import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodwala.model.Item;



@Repository
public interface ItemRepo extends JpaRepository<Item, Integer>{
	
	public Item findByitemName(String itemName);


}

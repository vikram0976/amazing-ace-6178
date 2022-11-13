package com.foodwala.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodwala.exception.CategoryException;
import com.foodwala.exception.ItemException;
import com.foodwala.exception.RestaurantExecption;
import com.foodwala.model.Category;
import com.foodwala.model.Item;
import com.foodwala.model.Restaurant;
import com.foodwala.repository.CategoryRepo;
import com.foodwala.repository.ItemRepo;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemRepo iRepo;
	
	@Autowired
	private CategoryRepo cRepo;
	
	@Override
	public Item addItem(Item item) throws ItemException {
		
		if(item==null) {
			throw new ItemException("item object should not be null");
		}
		Item it= iRepo.save(item);
		
		return it;
	}

	@Override
	public Item updateItem(Item item) throws ItemException {
		
		if(item==null) {
			throw new ItemException("item object should not be null");
		}
		Integer iid= item.getItemId();
		Optional<Item> op= iRepo.findById(iid);
		
		if(op.isPresent()) {
			
			Item it= op.get();	
			 iRepo.save(it);
			 return it;
		}else {
			throw new ItemException("item not available try to change item id");
		}
	}

	@Override
	public Item removeItem(Item item) throws ItemException {
		
		if(item==null) {
			throw new ItemException("item object should not be null");
		}
		Integer iid= item.getItemId();
		Optional<Item> op= iRepo.findById(iid);
		if(op.isPresent()) {
			
			Item it= op.get();	
			 iRepo.delete(it);
			 return it;
		}else {
			throw new ItemException("item not available try to change item id");
		}
	}

	@Override
	public Item viewItem(Item item) throws ItemException {
		
		if(item==null) {
			throw new ItemException("item object should not be null");
		}
		Integer iid= item.getItemId();
		Optional<Item> op= iRepo.findById(iid);
		if(op.isPresent()) {
			
			Item it= op.get();	
			 return it;
		}else {
			throw new ItemException("item not available try to change item id");
		}
	}

	@Override
	public List<Item> viewAllCItems(Category category) throws ItemException, CategoryException {
		
		Optional<Category> cat= cRepo.findById(category.getCatId());
		if(cat.isEmpty()) {
			throw new CategoryException("no category exist ");
		}
		else {
			
			//List<Item> itemList = iRepo.findAllById(cat.get().getCatId());
			
			List<Item> items = iRepo.findAllByCategory(category);
			
			if(items.isEmpty()) {
				throw new ItemException("no item found by the give category name");
			}else {
				return items;
			}
			
			
		
		}
		
		
	}

	@Override
	public List<Item> viewAllRItems(Restaurant res) throws ItemException, RestaurantExecption {
		
		return null;
	}

	@Override
	public List<Item> viewAllItemsByName(String name) throws ItemException {
		if(name==null) {
			throw new ItemException("item object should not be null");
		}
		
		List<Item> allitem= iRepo.findAllByItemName(name);
		
		if(allitem.size()==0) {
			throw new ItemException("no item available by this name");
		}
		
		return allitem;
	}

}

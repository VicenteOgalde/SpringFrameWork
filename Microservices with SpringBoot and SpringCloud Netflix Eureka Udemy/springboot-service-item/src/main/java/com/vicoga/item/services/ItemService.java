package com.vicoga.item.services;

import java.util.List;

import com.vicoga.commons.models.entities.Product;
import com.vicoga.item.models.Item;


public interface ItemService {
	
	public List<Item> findAll();
	
	public Item findById(Long id,Integer amount);
	
	public Product save(Product product);
	
	public Product update(Product product, Long id);
	
	public void delete(Long id);

}

package com.vicoga.item.services;

import java.util.List;

import com.vicoga.item.models.Item;

public interface ItemService {
	
	public List<Item> findAll();
	
	public Item findById(Long id,Integer amount);

}

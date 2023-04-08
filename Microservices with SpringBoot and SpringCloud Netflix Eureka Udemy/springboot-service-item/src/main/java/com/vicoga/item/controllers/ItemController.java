package com.vicoga.item.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vicoga.item.models.Item;
import com.vicoga.item.services.ItemService;

@RestController
public class ItemController {

	@Autowired
	@Qualifier("serviceFeign")
	private ItemService service;
	
	@GetMapping("/list")
	public List<Item> list(){
		return service.findAll();
	}
	@GetMapping("/show/{id}/amount/{amount}")
	public Item show(@PathVariable Long id,@PathVariable Integer amount) {
		return service.findById(id, amount);
	}
}

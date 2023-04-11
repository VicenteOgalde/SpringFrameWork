package com.vicoga.item.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vicoga.item.models.Item;
import com.vicoga.item.models.Product;
import com.vicoga.item.services.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	private CircuitBreakerFactory circuitBreakerFactory;
	
	private Logger log = LoggerFactory.getLogger(ItemController.class);
	
	@Autowired
	@Qualifier("serviceFeign")
	private ItemService service;
	
	@GetMapping("/list")
	public List<Item> list(@RequestParam(name = "name",required = false)String name,@RequestHeader(name = "token-request",required = false)String tokenRequest){
		System.out.println(name);
		System.out.println(tokenRequest);
		return service.findAll();
	}
	@GetMapping("/show/{id}/amount/{amount}")
	public Item show(@PathVariable Long id,@PathVariable Integer amount) {
		return circuitBreakerFactory.create("items")
				.run(()-> service.findById(id, amount),e->alternativeMethod(id, amount,e));
	}
	
	public Item alternativeMethod(Long id,Integer amount,Throwable e) {
		
		log.info("Error: ".concat(e.getMessage()));
		
		Item i= new Item(new Product("default product"),amount);
		i.getProduct().setId(id);
		i.getProduct().setPrice(1000.0);
		return i;
	}
}

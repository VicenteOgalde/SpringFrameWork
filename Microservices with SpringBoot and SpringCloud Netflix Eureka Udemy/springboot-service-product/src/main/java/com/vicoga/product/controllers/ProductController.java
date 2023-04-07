package com.vicoga.product.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vicoga.product.models.entities.Product;
import com.vicoga.product.models.services.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping("/list")
	public List<Product> list(){
		return service.findAll();
	}
	
	@GetMapping("/show/{id}")
	public Product listById(@PathVariable Long id){
		return service.findById(id);
	}

}

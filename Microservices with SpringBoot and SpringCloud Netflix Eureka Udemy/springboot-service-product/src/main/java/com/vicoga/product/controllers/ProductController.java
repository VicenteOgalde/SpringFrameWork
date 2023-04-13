package com.vicoga.product.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vicoga.commons.models.entities.Product;
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
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Product create(@RequestBody Product product) {
		
		return service.save(product);
	}
	
	@PutMapping("/edit/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Product update(@RequestBody Product product,@PathVariable Long id) {
		
		Product p= service.findById(id);
		p.setName(product.getName());
		p.setPrice(product.getPrice());
		return service.save(p);
		
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

}

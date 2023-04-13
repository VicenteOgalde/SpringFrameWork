package com.vicoga.product.models.services;

import java.util.List;

import com.vicoga.commons.models.entities.Product;

public interface ProductService {
	
	public List<Product> findAll();
	
	public Product findById(Long id);
	
	public Product save(Product product);
	
	public void delete(Long id);

}

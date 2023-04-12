package com.vicoga.product.models.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vicoga.product.models.entities.Product;
import com.vicoga.product.models.repositories.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Product> findAll() {
		
		return (List<Product>) repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Product findById(Long id) {
		
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Product save(Product product) {
		
		return repository.save(product);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
		
	}

}

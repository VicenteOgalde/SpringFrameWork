package com.vicoga.webflux.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vicoga.webflux.models.documents.Category;
import com.vicoga.webflux.models.documents.Product;
import com.vicoga.webflux.models.repositories.CategoryRepository;
import com.vicoga.webflux.models.repositories.ProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Flux<Product> findAll() {
		
		return productRepository.findAll();
	}

	@Override
	public Flux<Product> findAllWithNameUpperCase() {
		
		return productRepository.findAll().map(
				p->{
					p.setName(p.getName().toUpperCase());
					return p;
					});
	}

	@Override
	public Flux<Product> findAllWithNameUpperCaseRepeat() {
		
		return  findAllWithNameUpperCase().repeat(1000);
	}

	@Override
	public Mono<Product> findById(String id) {
		
		return productRepository.findById(id);
	}

	@Override
	public Mono<Product> save(Product product) {
		
		return productRepository.save(product);
	}

	@Override
	public Mono<Void> delete(Product product) {
		
		return productRepository.delete(product);
	}

	@Override
	public Flux<Category> findAllCategories() {
		
		return categoryRepository.findAll();
	}

	@Override
	public Mono<Category> findCategoryById(String id) {
		
		return categoryRepository.findById(id);
	}

	@Override
	public Mono<Category> saveCategory(Category category) {
		
		return categoryRepository.save(category);
	}

}

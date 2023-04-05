package com.vicoga.webflux.models.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.vicoga.webflux.models.documents.Product;

import reactor.core.publisher.Mono;

public interface ProductRepository extends ReactiveMongoRepository<Product, String>{
	
	public Mono<Product> findByName(String name);
	
	//@Query("{ 'name' : ?0}")
	//public Mono<Product> lookByName(String name);

}

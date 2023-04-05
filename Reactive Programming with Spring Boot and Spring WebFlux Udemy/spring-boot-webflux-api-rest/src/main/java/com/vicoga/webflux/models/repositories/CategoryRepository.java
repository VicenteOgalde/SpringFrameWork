package com.vicoga.webflux.models.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.vicoga.webflux.models.documents.Category;

import reactor.core.publisher.Mono;

public interface CategoryRepository extends ReactiveMongoRepository<Category, String>{
	
	public Mono<Category> findByName(String name);

}

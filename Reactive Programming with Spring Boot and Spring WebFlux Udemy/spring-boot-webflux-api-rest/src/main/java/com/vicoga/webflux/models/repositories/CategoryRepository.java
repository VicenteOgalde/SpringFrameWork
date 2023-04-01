package com.vicoga.webflux.models.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.vicoga.webflux.models.documents.Category;

public interface CategoryRepository extends ReactiveMongoRepository<Category, String>{

}

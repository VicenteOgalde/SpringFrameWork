package com.vicoga.webflux.models.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.vicoga.webflux.models.documents.Product;

public interface ProductRepository extends ReactiveMongoRepository<Product, String>{

}

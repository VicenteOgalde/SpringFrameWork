package com.vicoga.product.models.repositories;

import org.springframework.data.repository.CrudRepository;
import com.vicoga.commons.models.entities.Product;
public interface ProductRepository extends CrudRepository<Product, Long>{

}

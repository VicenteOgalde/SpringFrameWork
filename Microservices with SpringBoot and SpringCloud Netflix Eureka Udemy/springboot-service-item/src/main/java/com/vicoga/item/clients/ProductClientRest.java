package com.vicoga.item.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vicoga.item.models.Product;

@FeignClient(name="product-service",url="localhost:8001")
public interface ProductClientRest {

	@GetMapping("/list")
	public List<Product> list();
	@GetMapping("/show/{id}")
	public Product findById(@PathVariable Long id);
}

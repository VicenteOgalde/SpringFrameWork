package com.vicoga.item.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vicoga.item.models.Item;
import com.vicoga.item.models.Product;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private RestTemplate restClient;

	@Override
	public List<Item> findAll() {
		List<Product> products= Arrays.asList(restClient.getForObject("http://product-service/list",Product[].class));
		return products.stream().map(p->new Item(p,1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer amount) {
		Product product= restClient.getForObject("http://product-service/show/".concat(id.toString()), Product.class);
		return new Item(product,amount);
	}

	@Override
	public Product save(Product product) {
		HttpEntity<Product> body= new HttpEntity<Product>(product);
		ResponseEntity<Product> response= restClient.exchange("http://product-service/create",HttpMethod.POST, body,Product.class);
		return response.getBody();
	}

	@Override
	public Product update(Product product, Long id) {
		HttpEntity<Product> body= new HttpEntity<Product>(product);
		ResponseEntity<Product> response= restClient.exchange("http://product-service/edit/".concat(id.toString()),HttpMethod.PUT, body,Product.class);
		return response.getBody();
	}

	@Override
	public void delete(Long id) {
		restClient.delete("http://product-service/delete/".concat(id.toString()));
		
		
	}

}

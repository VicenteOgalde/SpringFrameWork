package com.vicoga.item.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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
		List<Product> products= Arrays.asList(restClient.getForObject("http://localhost:8001/list",Product[].class));
		return products.stream().map(p->new Item(p,1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer amount) {
		Product product= restClient.getForObject("http://localhost:8001/show/".concat(id.toString()), Product.class);
		return new Item(product,amount);
	}

}

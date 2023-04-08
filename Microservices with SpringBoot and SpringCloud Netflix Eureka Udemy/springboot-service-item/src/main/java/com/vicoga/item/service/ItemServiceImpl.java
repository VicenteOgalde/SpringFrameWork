package com.vicoga.item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vicoga.item.models.Item;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private RestTemplate restClient;

	@Override
	public List<Item> findAll() {
		
		return null;
	}

	@Override
	public Item findById(Long id, Integer amount) {
		
		return null;
	}

}

package com.vicoga.item.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.vicoga.commons.models.entities.Product;
import com.vicoga.item.clients.ProductClientRest;
import com.vicoga.item.models.Item;

@Service("serviceFeign")
public class ItemServiceFeign implements ItemService{
	
	@Autowired
	private ProductClientRest clientFeign;

	@Override
	public List<Item> findAll() {
		
		return clientFeign.list().stream().map(p->new Item(p,1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer amount) {
		
		return new Item(clientFeign.findById(id),amount);
	}

	@Override
	public Product save(Product product) {
		
		return clientFeign.create(product);
	}

	@Override
	public Product update(Product product, Long id) {
		
		return clientFeign.update(product, id);
	}

	@Override
	public void delete(Long id) {
		clientFeign.delete(id);
		
	}

}

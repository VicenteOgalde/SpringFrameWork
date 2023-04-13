package com.vicoga.item.models;

import com.vicoga.commons.models.entities.Product;

public class Item {

	private Product product;
	private Integer amount;
	
	
	
	public Item() {
		
	}
	
	public Item(Product product, Integer amount) {
		
		this.product = product;
		this.amount = amount;
	}

	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Double getTotal() {
		return this.product.getPrice()*this.amount.doubleValue();
	}
	
	
}

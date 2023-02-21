package com.vicoga.di.app.models.entities;

public class InvoiceItem {

	private Product product;
	private Integer amount;
	

	public InvoiceItem(Product product, Integer amount) {
		
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

}

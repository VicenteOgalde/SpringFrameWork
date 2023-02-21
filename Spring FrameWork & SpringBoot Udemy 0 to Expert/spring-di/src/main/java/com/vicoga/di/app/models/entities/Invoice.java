package com.vicoga.di.app.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class Invoice implements Serializable{

	private static final long serialVersionUID = -1414985676828476086L;
	@Value("${desc.invoice}")
	private String description;
	@Autowired
	private Client client;
	@Autowired
	private List<InvoiceItem> items;
	

@PostConstruct
	public void init() {
	this.client.setName(this.client.getName().concat(" ").concat("xin"));
	}
@PreDestroy
public void preDestroy() {System.out.println("destroy "+this.description);}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<InvoiceItem> getItems() {
		return items;
	}

	public void setItems(List<InvoiceItem> items) {
		this.items = items;
	}

}

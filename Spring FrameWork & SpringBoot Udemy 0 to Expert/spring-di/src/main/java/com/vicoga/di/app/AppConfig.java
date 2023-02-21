package com.vicoga.di.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.vicoga.di.app.models.entities.InvoiceItem;
import com.vicoga.di.app.models.entities.Product;
import com.vicoga.di.app.models.services.IService;
import com.vicoga.di.app.models.services.MeService;
import com.vicoga.di.app.models.services.MeServiceComplex;

@Configuration
public class AppConfig {

	@Bean("firstService")
	public IService serviceRegister() {
		return new MeService();
	}
	@Bean("complexService")
	@Primary
	public IService serviceRegisterComplex() {
		return new MeServiceComplex();
	}
	@Bean("itemsInvoice")
	public List<InvoiceItem> itemsRegister(){
		Product product= new Product("bike", 2000);
		Product product2= new Product("pen", 150);
		Product product3= new Product("tv", 2200);
		
		InvoiceItem items= new InvoiceItem(product, 2);
		InvoiceItem items2= new InvoiceItem(product2, 10);
		InvoiceItem items3= new InvoiceItem(product3, 5);
		
		return Arrays.asList(items,items2,items3);
	}
}

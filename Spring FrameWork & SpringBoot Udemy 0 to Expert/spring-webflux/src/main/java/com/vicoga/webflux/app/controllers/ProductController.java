package com.vicoga.webflux.app.controllers;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;

import com.vicoga.webflux.app.models.dao.ProductDao;
import com.vicoga.webflux.app.models.documents.Product;

import reactor.core.publisher.Flux;

@Controller
public class ProductController {
	
	@Autowired
	private ProductDao repository;
	
	@GetMapping({"/list","/"})
	public String productList(Model model) {
		Flux<Product>products=repository.findAll();
		model.addAttribute("products", products);
		model.addAttribute("title", "Products List");
		return "list";
	}
	
	@GetMapping("/list-datadriver")
	public String listDataDriver(Model model) {
		Flux<Product>products=repository.findAll().delayElements(Duration.ofSeconds(1));
		model.addAttribute("products",new ReactiveDataDriverContextVariable(products, 1));
		model.addAttribute("title", "Products List");
		return "list";
	}
	
	@GetMapping("/list-full")
	public String productListFull(Model model) {
		Flux<Product>products=repository.findAll().repeat(5000);
		model.addAttribute("products", products);
		model.addAttribute("title", "Products List");
		return "list";
	}
}

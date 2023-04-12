package com.vicoga.item.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vicoga.item.models.Item;
import com.vicoga.item.models.Product;
import com.vicoga.item.services.ItemService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

@RestController
public class ItemController {
	
	@Autowired
	private CircuitBreakerFactory circuitBreakerFactory;
	@Value("${config.text}")
	private String text;
	
	private Logger log = LoggerFactory.getLogger(ItemController.class);
	
	@Autowired
	@Qualifier("serviceFeign")
	private ItemService service;
	
	@GetMapping("/list")
	public List<Item> list(@RequestParam(name = "name",required = false)String name,@RequestHeader(name = "token-request",required = false)String tokenRequest){
		System.out.println(name);
		System.out.println(tokenRequest);
		return service.findAll();
	}
	
	@GetMapping("/show/{id}/amount/{amount}")
	public Item show(@PathVariable Long id,@PathVariable Integer amount) {
		return circuitBreakerFactory.create("items")
				.run(()-> service.findById(id, amount),e->alternativeMethod(id, amount,e));
	}
	
	@CircuitBreaker(name = "items", fallbackMethod = "alternativeMethod")
	@GetMapping("/show2/{id}/amount/{amount}")
	public Item show2(@PathVariable Long id,@PathVariable Integer amount) {
		return service.findById(id, amount);
	}
	
	@CircuitBreaker(name="items",fallbackMethod ="alternativeMethod2" )
	@TimeLimiter(name = "items")
	@GetMapping("/show3/{id}/amount/{amount}")
	public CompletableFuture <Item> show3(@PathVariable Long id,@PathVariable Integer amount) {
		return CompletableFuture.supplyAsync(()-> service.findById(id, amount));
	}
	
	public Item alternativeMethod(Long id,Integer amount,Throwable e) {
		
		log.info("Error: ".concat(e.getMessage()));
		
		Item i= new Item(new Product("default product"),amount);
		i.getProduct().setId(id);
		i.getProduct().setPrice(1000.0);
		return i;
	}
	
	
	public CompletableFuture <Item> alternativeMethod2(Long id,Integer amount,Throwable e) {
		
		log.info("Error: ".concat(e.getMessage()));
		
		Item i= new Item(new Product("default product"),amount);
		i.getProduct().setId(id);
		i.getProduct().setPrice(1000.0);
		return CompletableFuture.supplyAsync(()-> i) ;
	}
	
	@GetMapping("/get-config")
	public ResponseEntity<?> getConfig(@Value("${server.port}") String port){
		Map<String,String> json= new HashMap<String, String>();
		json.put("text", text);
		json.put("port", port);
		return new ResponseEntity<Map<String,String>>(json,HttpStatus.OK);
	}
}

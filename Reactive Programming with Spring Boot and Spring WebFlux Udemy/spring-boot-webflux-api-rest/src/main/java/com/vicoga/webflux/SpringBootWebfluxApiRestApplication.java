package com.vicoga.webflux;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import com.vicoga.webflux.models.documents.Category;
import com.vicoga.webflux.models.documents.Product;
import com.vicoga.webflux.models.services.ProductService;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class SpringBootWebfluxApiRestApplication implements CommandLineRunner{

	@Autowired
	private ProductService service;
	
	@Autowired
	private ReactiveMongoTemplate mongoTemplate;
	
	private static final Logger log = LoggerFactory.getLogger(SpringBootWebfluxApiRestApplication.class);
	

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebfluxApiRestApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		mongoTemplate.dropCollection("products").subscribe();
		mongoTemplate.dropCollection("categories").subscribe();
		
		Category electronic = new Category("Electronic");
		Category sport = new Category("sport");
		Category it = new Category("it");
		Category furniture = new Category("furniture");
		
		Flux.just(electronic, sport, it, furniture)
		.flatMap(service::saveCategory)
		.doOnNext(c ->{
			log.info("Category : " + c.getName() + ", Id: " + c.getId());
		}).thenMany(
				Flux.just(new Product("TV Panasonic LCD", 456.89, electronic),
						new Product("Sony Camera HD Digital", 177.89, electronic),
						new Product("Apple iPod", 46.89, electronic),
						new Product("Sony Notebook", 846.89, it),
						new Product("Hewlett Packard Multifuncional", 200.89, it),
						new Product("Bianchi ", 70.89, sport),
						new Product("HP Notebook Omen 17", 2500.89, it),
						new Product("Sofa", 150.89, furniture),
						new Product("TV Sony Bravia OLED 4K Ultra HD", 2255.89, electronic)
						)
				.flatMap(product -> {
					product.setCreateAt(new Date());
					return service.save(product);
					})
		)
		.subscribe(product -> log.info("Insert: " + product.getId() + " " + product.getName()));
		
	}


}

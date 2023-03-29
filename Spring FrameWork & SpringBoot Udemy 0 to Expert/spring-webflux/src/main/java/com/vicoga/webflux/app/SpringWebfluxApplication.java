package com.vicoga.webflux.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import com.vicoga.webflux.app.models.dao.ProductDao;
import com.vicoga.webflux.app.models.documents.Product;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class SpringWebfluxApplication implements CommandLineRunner{
	
	@Autowired
	private ProductDao repository;
	
	@Autowired
	private ReactiveMongoTemplate template;
	
	private static final Logger log= LoggerFactory.getLogger(SpringWebfluxApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringWebfluxApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		template.dropCollection("products").subscribe();
		Flux.just(new Product("tv",2000.0),
				new Product("tv2",2040.0),
				new Product("tv3",2004.0),
				new Product("tv4",2002.0),
				new Product("tv5",2050.0))
		.flatMap(p->repository.save(p))
		.subscribe(p->log.info(p.getName()));
		
	}

}

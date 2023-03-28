package com.vicoga.reactor.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class SpringReactorApplication implements CommandLineRunner{
	
	private static final Logger log = LoggerFactory.getLogger(SpringReactorApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringReactorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Flux<String> names= Flux.just("name1","name2","name3")
				.doOnNext(e->{
					if(e.isBlank()) {
						throw new RuntimeException("name is empty");
					}else {
				System.out.println(e);
				}}
				)
				.map(String::toUpperCase);
		
		names.subscribe(log::info,e->log.error(e.getMessage()),new Runnable() {
			
			@Override
			public void run() {
				log.info("end cycle");
				
			}
		});
		
	}

}

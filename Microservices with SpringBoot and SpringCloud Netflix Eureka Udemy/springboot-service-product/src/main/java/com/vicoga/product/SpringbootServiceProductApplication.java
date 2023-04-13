package com.vicoga.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.vicoga.commons.models.entities"})
public class SpringbootServiceProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiceProductApplication.class, args);
	}

}

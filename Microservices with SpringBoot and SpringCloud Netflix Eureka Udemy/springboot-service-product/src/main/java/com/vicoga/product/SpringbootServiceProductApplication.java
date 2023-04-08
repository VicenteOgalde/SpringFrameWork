package com.vicoga.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class SpringbootServiceProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiceProductApplication.class, args);
	}

}

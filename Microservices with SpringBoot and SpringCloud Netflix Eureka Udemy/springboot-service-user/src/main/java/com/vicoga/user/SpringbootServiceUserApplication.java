package com.vicoga.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.vicoga.commons.user.models.entities"})
public class SpringbootServiceUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiceUserApplication.class, args);
	}

}

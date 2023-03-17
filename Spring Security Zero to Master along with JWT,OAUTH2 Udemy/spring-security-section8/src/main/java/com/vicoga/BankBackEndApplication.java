package com.vicoga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity(debug=true)
@SpringBootApplication
public class BankBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankBackEndApplication.class, args);
	}

}

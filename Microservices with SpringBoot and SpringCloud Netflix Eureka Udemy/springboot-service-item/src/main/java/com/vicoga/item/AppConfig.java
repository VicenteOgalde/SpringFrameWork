package com.vicoga.item;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	@Bean("restClient")
	public RestTemplate restTemplateRegister() {
		return new RestTemplate();
	}
	
	
}

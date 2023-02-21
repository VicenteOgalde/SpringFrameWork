package com.vicoga.di.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.vicoga.di.app.models.services.IService;
import com.vicoga.di.app.models.services.MeService;
import com.vicoga.di.app.models.services.MeServiceComplex;

@Configuration
public class AppConfig {

	@Bean("firstService")
	public IService serviceRegister() {
		return new MeService();
	}
	@Bean("complexService")
	@Primary
	public IService serviceRegisterComplex() {
		return new MeServiceComplex();
	}
}

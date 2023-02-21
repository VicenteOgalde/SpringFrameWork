package com.vicoga.di.app.models.services;

import org.springframework.stereotype.Component;

@Component
public class MeService {
	
	public String operation() {
		return"some process";
	}

}

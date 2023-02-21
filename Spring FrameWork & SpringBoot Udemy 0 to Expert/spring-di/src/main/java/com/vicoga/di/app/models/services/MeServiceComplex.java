package com.vicoga.di.app.models.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("meServiceComplex")
@Primary
public class MeServiceComplex implements IService {
	
	@Override
	public String operation() {
		return"some complex process";
	}

}

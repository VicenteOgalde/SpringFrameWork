package com.vicoga.di.app.models.services;

import org.springframework.stereotype.Component;

//@Component("firstService")
public class MeService implements IService {
	
	@Override
	public String operation() {
		return"some process";
	}

}

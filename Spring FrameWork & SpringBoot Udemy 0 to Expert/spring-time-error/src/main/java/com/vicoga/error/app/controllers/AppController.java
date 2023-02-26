package com.vicoga.error.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	
	@SuppressWarnings("unused")
	@GetMapping("/index")
	public String index() {
		Integer val=0;
		//val= 100/0;
		val=Integer.parseInt("hola");
		
		return "index";
	}
}

package com.vicoga.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.vicoga.di.app.models.services.IService;


@Controller
public class IndexController {

	@Autowired
	//@Qualifier("firstService")
	private IService service;

	@GetMapping({"/","","/index"})
	public String index(Model model) {
		model.addAttribute("object",service.operation());
		return "index";
	}
	

	
	
	
}

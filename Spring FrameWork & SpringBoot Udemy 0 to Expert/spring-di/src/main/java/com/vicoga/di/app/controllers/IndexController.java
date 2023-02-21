package com.vicoga.di.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.vicoga.di.app.models.services.MeService;

@Controller
public class IndexController {
	private MeService service= new MeService();

	@GetMapping({"/","","/index"})
	public String index(Model model) {
		model.addAttribute("object",service.operation());
		return "index";
	}
}

package com.vicoga.form.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {
	@GetMapping("/form")
	public String form(Model model) {
		
		
		return "form";
	}
	@PostMapping
	public String formPost(Model model) {
		return"result";
	}

}

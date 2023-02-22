package com.vicoga.form.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {
	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("title", "Form thymeleaf");
		
		return "form";
	}
	@PostMapping("/form")
	public String formPost(Model model,
			@RequestParam String name,
			@RequestParam String pass,
			@RequestParam String email) {
		model.addAttribute("title", "Form Result");
		model.addAttribute("name", name);
		model.addAttribute("pass", pass);
		model.addAttribute("email", email);
		
		
		return"form-result";
	}

}

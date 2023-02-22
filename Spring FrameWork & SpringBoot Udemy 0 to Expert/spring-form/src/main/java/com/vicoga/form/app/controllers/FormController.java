package com.vicoga.form.app.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.vicoga.form.app.models.User;

@Controller
public class FormController {
	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("title", "Form thymeleaf");
		
		return "form";
	}
	@PostMapping("/form")
	public String formPost(@Valid User user,BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			Map<String, String> errors= new HashMap<String, String>();
			result.getFieldErrors().forEach(e->{
				errors.put(e.getField(), e.getDefaultMessage());
			});
			model.addAttribute("errors",errors);
			return"form";
		}
		
		//User user= new User(name,pass,email);
		model.addAttribute("title", "Form Result");
		model.addAttribute("user", user);
		
		
		
		return"form-result";
	}

}

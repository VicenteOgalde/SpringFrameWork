package com.vicoga.form.app.controllers;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;


import com.vicoga.form.app.models.User;
import com.vicoga.form.app.validation.UserValidation;

@Controller
public class FormController {
	
	@Autowired
	private UserValidation validation;
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(validation);
	}
	
	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("title", "Form thymeleaf");
		model.addAttribute("user",new User());
		
		return "form";
	}
	@PostMapping("/form")
	public String formPost(@Valid User user,BindingResult result, Model model) {
		
		//validation.validate(user, result);
		
		if(result.hasErrors()) {
			/*
			Map<String, String> errors= new HashMap<String, String>();
			result.getFieldErrors().forEach(e->{
				errors.put(e.getField(), e.getDefaultMessage());
			});*/
			
			
			model.addAttribute("title", "Form thymeleaf");
			return"form";
		}
		
		//User user= new User(name,pass,email);
		model.addAttribute("title", "Form Result");
		model.addAttribute("user", user);
		
		
		
		return"form-result";
	}

}

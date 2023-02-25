package com.vicoga.form.app.controllers;



import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vicoga.form.app.editors.UppercaseEditor;
import com.vicoga.form.app.models.User;
import com.vicoga.form.app.validation.UserValidation;

@Controller
public class FormController {
	
	@Autowired
	private UserValidation validation;
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(validation);
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class,"dateB",new CustomDateEditor(dateFormat,false));
		
		binder.registerCustomEditor(String.class, "name",new UppercaseEditor());
		
	}
	
	@ModelAttribute("countries")
	public List<String> countries(){
		return Arrays.asList("Spain","Mexico","Chile");
	}
	@ModelAttribute("countriesMap")
	public Map<String,String> countriesMap(){
		Map<String,String> countriesMap=new HashMap<String, String>();
		countriesMap.put("SP", "Spain");
		countriesMap.put("MX", "Mexico");
		countriesMap.put("CL", "Chile");
		return countriesMap;
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

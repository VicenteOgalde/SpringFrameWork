package com.vicoga.datajpa.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.vicoga.datajpa.app.models.dao.ClientDao;
import com.vicoga.datajpa.app.models.entity.Client;

@Controller
public class ClientController {
	@Autowired
	@Qualifier("clientDaoJpa")
	private ClientDao repository;
	
	@GetMapping(value = "/list")
	public String clientList(Model model) {
		List<Client> clients= repository.findAll();
		model.addAttribute("clients",clients);
		model.addAttribute("title", "Testing JPA");
		
		return "list";
	}
	@GetMapping("/form")
	public String create(Model model) {
		
		model.addAttribute("client",new Client());
		model.addAttribute("title", "Form");
		return "form";
	}
	@PostMapping("/form")
	public String save(@Valid Client client,BindingResult binding,Model model) {
		if(binding.hasErrors()) {
			model.addAttribute("title", "Form");
			return"form";
		}
		repository.save(client);
		
		return"redirect:list";
	}

}

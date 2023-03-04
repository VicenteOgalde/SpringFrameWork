package com.vicoga.datajpa.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.vicoga.datajpa.app.models.dao.ClientDao;
import com.vicoga.datajpa.app.models.entity.Client;
import com.vicoga.datajpa.app.models.service.ClientService;

@Controller
@SessionAttributes("client")
public class ClientController {

	@Autowired
	private ClientService service;

	@GetMapping(value = "/list")
	public String clientList(@RequestParam(name="page" , defaultValue = "0")int page, Model model) {
		
		
		Page<Client> clients = service.findAll(PageRequest.of(page, 4));
		model.addAttribute("clients", clients);
		model.addAttribute("title", "Testing JPA");

		return "list";
	}

	@GetMapping("/form")
	public String create(Model model) {

		model.addAttribute("client", new Client());
		model.addAttribute("title", "Form");
		return "form";
	}

	@GetMapping("/form/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Client c = null;
		if (id > 0) {
			c = service.findById(id);
		} else {

			return "redirect:list";
		}
		model.addAttribute("title", "Edit Client");
		model.addAttribute("client", c);
		return "form";
	}

	@PostMapping("/form")
	public String save(@Valid Client client, BindingResult binding, Model model, SessionStatus status) {
		if (binding.hasErrors()) {
			model.addAttribute("title", "Form");
			return "form";
		}
		service.save(client);
		status.setComplete();
		return "redirect:list";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable(value="id")Long id) {
		if(id>0) {
			service.deleteById(id);
		}
		return "redirect:/list";
	}

}

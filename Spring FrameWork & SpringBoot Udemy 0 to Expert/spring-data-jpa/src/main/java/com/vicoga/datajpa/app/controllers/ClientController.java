package com.vicoga.datajpa.app.controllers;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import javax.validation.Valid;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.vicoga.datajpa.app.models.entity.Client;
import com.vicoga.datajpa.app.models.service.ClientService;
import com.vicoga.datajpa.app.util.paginator.PageRender;

@Controller
@SessionAttributes("client")
public class ClientController {

	@Autowired
	private ClientService service;
	
	private final Logger log= LoggerFactory.getLogger(getClass());
	
	@GetMapping(value = "/show/{id}")
	public String show(@PathVariable(value = "id")Long id,Model model) {
		
		Client c= service.findById(id);
		if(c==null) {
			return "redirect:/list";
		}
		model.addAttribute("client", c);
		model.addAttribute("title", "-=".concat(c.getName()).concat("=-"));
		
		return "show";
	}

	@GetMapping(value = "/list")
	public String clientList(@RequestParam(name="page" , defaultValue = "0")int page, Model model) {
		
		
		Page<Client> clients = service.findAll(PageRequest.of(page, 10));
		PageRender<Client> pageRender= new PageRender<Client>("/list", clients);
		
		model.addAttribute("clients", clients);
		model.addAttribute("title", "Testing JPA");
		model.addAttribute("page",pageRender);

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
	public String save(@Valid Client client, BindingResult binding, Model model,@RequestParam("file") MultipartFile file, SessionStatus status) {
		if (binding.hasErrors()) {
			model.addAttribute("title", "Form");
			return "form";
		}
		if(!file.isEmpty()) {
			String uniqueFilename= UUID.randomUUID().toString().concat("_").concat(file.getOriginalFilename());
			Path rootPath= Paths.get("upload").resolve(uniqueFilename);
			Path absolutePath= rootPath.toAbsolutePath();
			
			log.info("root path: ".concat(rootPath.toString()));
			log.info("absolute path: ".concat(absolutePath.toString()));
			try {
				/*
				byte[] bytes=file.getBytes();
				Path fullPath=Paths.get(rootPath+("//").concat(file.getOriginalFilename()));
				Files.write(fullPath, bytes);*/
				Files.copy(file.getInputStream(), absolutePath);
				client.setPhoto(uniqueFilename);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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

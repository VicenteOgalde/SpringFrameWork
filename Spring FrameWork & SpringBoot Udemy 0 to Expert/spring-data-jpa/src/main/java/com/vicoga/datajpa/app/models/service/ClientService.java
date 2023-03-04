package com.vicoga.datajpa.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vicoga.datajpa.app.models.entity.Client;

public interface ClientService {
	
	List<Client> findAll();
	void save(Client c);
	Client findById(Long id);
	void deleteById(Long id);
	Page<Client> findAll(Pageable pageable);

	
}

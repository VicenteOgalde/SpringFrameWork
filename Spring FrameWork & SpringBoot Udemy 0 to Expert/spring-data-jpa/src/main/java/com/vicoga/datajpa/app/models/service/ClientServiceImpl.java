package com.vicoga.datajpa.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vicoga.datajpa.app.models.dao.ClientDao;
import com.vicoga.datajpa.app.models.entity.Client;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientDao repository;
	@Transactional(readOnly = true)
	@Override
	public List<Client> findAll() {
		
		return (List<Client>) repository.findAll();
	}
	@Transactional
	@Override
	public void save(Client c) {
		repository.save(c);
		
	}
	@Transactional(readOnly = true)
	@Override
	public Client findById(Long id) {
		
		return repository.findById(id).orElse(null);
	}
	@Transactional
	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
		
	}
	@Override
	public Page<Client> findAll(Pageable pageable) {
		
		
		
		return repository.findAll(pageable);
	}
	
	

}

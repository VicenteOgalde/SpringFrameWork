package com.vicoga.datajpa.app.models.dao;

import java.util.List;

import com.vicoga.datajpa.app.models.entity.Client;

public interface ClientDao {
	
	List<Client> findAll();
	

}

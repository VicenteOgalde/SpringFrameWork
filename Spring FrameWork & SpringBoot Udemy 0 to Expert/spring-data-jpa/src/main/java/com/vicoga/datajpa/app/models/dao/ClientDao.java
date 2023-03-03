package com.vicoga.datajpa.app.models.dao;



import org.springframework.data.repository.CrudRepository;

import com.vicoga.datajpa.app.models.entity.Client;

public interface ClientDao extends CrudRepository<Client, Long> {
	


}

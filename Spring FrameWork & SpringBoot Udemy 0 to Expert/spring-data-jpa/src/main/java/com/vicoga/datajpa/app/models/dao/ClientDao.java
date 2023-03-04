package com.vicoga.datajpa.app.models.dao;



import org.springframework.data.jpa.repository.JpaRepository;


import com.vicoga.datajpa.app.models.entity.Client;

public interface ClientDao extends JpaRepository<Client, Long> {
	
	
	


}

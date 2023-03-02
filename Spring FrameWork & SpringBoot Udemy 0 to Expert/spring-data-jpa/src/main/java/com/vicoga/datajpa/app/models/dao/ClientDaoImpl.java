package com.vicoga.datajpa.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vicoga.datajpa.app.models.entity.Client;

@Repository("clientDaoJpa")
public class ClientDaoImpl implements ClientDao{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly = true)
	public List<Client> findAll() {
		return em.createQuery("from Client",Client.class).getResultList();
	}

}

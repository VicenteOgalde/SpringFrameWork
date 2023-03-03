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

	public List<Client> findAll() {
		return em.createQuery("from Client",Client.class).getResultList();
	}

	@Override
	
	public void save(Client c) {
		if(c.getId()!=null&&c.getId()>0) {
		em.merge(c);
		}else {
			em.persist(c);
		}
		
	}


	@Override
	public Client findById(Long id) {
		
		return em.find(Client.class, id);
	}

	@Override
	public void deleteById(Long id) {
		em.remove(findById(id));
		
	}

}

package com.vicoga.user.models.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.vicoga.user.models.entities.User;
@RepositoryRestResource(path = "v01")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	public User findByUsername(String username);
	
}

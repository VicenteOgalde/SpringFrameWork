package com.vicoga.user.models.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.vicoga.user.models.entities.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	public User findByUsername(String username);
	
}

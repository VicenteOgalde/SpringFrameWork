package com.vicoga.user.models.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.vicoga.user.models.entities.User;
@RepositoryRestResource(path = "v01")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	@RestResource(path = "find-username")
	public User findByUsername(@Param("username")String username);
	
}

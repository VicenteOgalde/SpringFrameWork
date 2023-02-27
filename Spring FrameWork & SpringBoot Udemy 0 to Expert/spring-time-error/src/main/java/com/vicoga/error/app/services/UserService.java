package com.vicoga.error.app.services;

import java.util.List;

import com.vicoga.error.app.models.domain.User;

public interface UserService {
	
	public List<User> findAll();
	public User findById(Integer id);

}

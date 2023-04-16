package com.vicoga.oauth.services;

import com.vicoga.commons.user.models.entities.User;

public interface IUserService {
	
	
	public User findByUsername(String username);

}

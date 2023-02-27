package com.vicoga.error.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vicoga.error.app.models.domain.User;



@Service
public class UserServiceImpl implements UserService {
	
	private List<User> users;

	
	public UserServiceImpl() {
		
		this.users = new ArrayList<User>();
		users.add(new User(1, "tex", "tox"));
		users.add(new User(2, "tix", "tax"));
		users.add(new User(3, "tox", "tax"));
		users.add(new User(4, "tux", "tax"));
	}

	@Override
	public List<User> findAll() {
		
		return this.users;
	}

	@Override
	public User findById(Integer id) {
		User user=null;
	
		for(User u:users) {
			if(u.getId().equals(id)) {
				user=u;
				break;
			}
		}
		
		return user;
	}

}

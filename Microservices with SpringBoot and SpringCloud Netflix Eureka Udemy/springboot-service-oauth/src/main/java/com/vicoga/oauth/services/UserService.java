package com.vicoga.oauth.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vicoga.commons.user.models.entities.User;
import com.vicoga.oauth.clients.UserFeignClient;
@Service
public class UserService implements  IUserService,UserDetailsService{
	
	private UserFeignClient client;

	public UserService(UserFeignClient client) {
		this.client=client;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user= client.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException(username.concat(" not found in the database."));
		}
		List<GrantedAuthority> roles=user.getRoles()
				.stream()
				.map(r->new SimpleGrantedAuthority(r.getName()))
				.collect(Collectors.toList());
		
		return new org.springframework.security.core.userdetails.User(
				user.getName(), user.getPassword(), user.getEnabled(),
				true, true, true, roles);
	}

	@Override
	public User findByUsername(String username) {
		
		return client.findByUsername(username);
	}

}

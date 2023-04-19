package com.vicoga.gateway.security;

import javax.crypto.SecretKey;
import javax.swing.JComboBox.KeySelectionManager;

import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

@Component
public class AuthenticationManagerJwt implements ReactiveAuthenticationManager{

	@Override
	public Mono<Authentication> authenticate(Authentication authentication) {
		
		
		return null;

	}}

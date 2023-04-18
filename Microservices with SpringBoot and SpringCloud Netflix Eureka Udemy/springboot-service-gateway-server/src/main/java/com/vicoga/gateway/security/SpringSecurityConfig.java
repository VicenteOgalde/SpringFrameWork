package com.vicoga.gateway.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
public class SpringSecurityConfig {

	@Bean
	public SecurityWebFilterChain configure(ServerHttpSecurity http) {
		return http
				.authorizeExchange()
				.pathMatchers("/api/security/oauth/**").permitAll()
				.pathMatchers(HttpMethod.GET,"/api/products/list"
						,"/api/products/show/{id}"
						,"/api/items/list"
						,"/api/items/show/{id}/amount/{amount}"
						,"/api/users/v01").permitAll()
				.pathMatchers(HttpMethod.GET,"/api/users/v01/{id}").hasAnyRole("ADMIN","USER")
				.pathMatchers("/api/items/**","/api/products/**","/api/users/v01/**").hasRole("ADMIN")
				.anyExchange().authenticated()
				.and().csrf().disable()
				.build();
	}
}

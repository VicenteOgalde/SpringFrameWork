package com.vicoga.oauth.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vicoga.commons.user.models.entities.User;

@FeignClient(name = "user-service")
public interface UserFeignClient {

	@GetMapping("/v01/search/find-username")
	public User findByUsername(@RequestParam String username);
	
}

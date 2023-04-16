package com.vicoga.oauth;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
public class SpringbootServiceOauthApplication implements CommandLineRunner{
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiceOauthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		String pass="12345";
		
		for (int i = 0; i < 4; i++) {
			String passE = passwordEncoder.encode(pass);
			System.out.println(passE);
		}
		
	}

}

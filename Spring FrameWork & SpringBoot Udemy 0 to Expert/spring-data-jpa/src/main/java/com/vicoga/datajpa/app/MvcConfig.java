package com.vicoga.datajpa.app;

import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer{
/*
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addResourceHandlers(registry);
		String rssPath= Paths.get("upload").toAbsolutePath().toUri().toString();
		
		registry.addResourceHandler("/upload/**")
		.addResourceLocations(rssPath);
	}
	
	*/

}

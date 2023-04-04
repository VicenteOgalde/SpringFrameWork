package com.vicoga.webflux;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import org.springframework.web.reactive.function.server.RouterFunction;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.vicoga.webflux.handler.ProductHandler;


@Configuration
public class RouterFunctionConfig {
	


	@Bean
	public RouterFunction<ServerResponse> routes(ProductHandler handler){
		return route(GET("/api/v2/products"), handler::list)
				.andRoute(GET("/api/v2/products/{id}"), handler::show)
				.andRoute(POST("/api/v2/products/"), handler::create)
				.andRoute(PUT("/api/v2/products/{id}"), handler::update)
				.andRoute(DELETE("/api/v2/products/{id}"), handler::delete);
	}
	
}

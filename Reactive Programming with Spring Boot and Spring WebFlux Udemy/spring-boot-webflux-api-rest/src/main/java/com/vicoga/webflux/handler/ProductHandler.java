package com.vicoga.webflux.handler;



import java.net.URI;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.vicoga.webflux.models.documents.Product;
import com.vicoga.webflux.models.services.ProductService;

import reactor.core.publisher.Mono;

@Component
public class ProductHandler {

	@Autowired
	private ProductService productService;
	
	public Mono<ServerResponse> list(ServerRequest request){
		
			return ServerResponse.ok()
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(productService.findAll(), Product.class);
					
		
	}
	public Mono<ServerResponse> show(ServerRequest request){
		String id = request.pathVariable("id");
		return productService.findById(id).flatMap(p->ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(Mono.just(p), Product.class))
				.switchIfEmpty(ServerResponse.notFound().build());
				
	
}
	public Mono<ServerResponse> create(ServerRequest request){
		Mono<Product> product = request.bodyToMono(Product.class);
		
		return product.flatMap(p->
		{
			if(p.getCreateAt()==null) {
				p.setCreateAt(new Date());
			}
			return productService.save(p);
		}
				).flatMap(p->ServerResponse.created(URI.create("/api/v2/products".concat(p.getId())))
						.contentType(MediaType.APPLICATION_JSON_UTF8)
						.body(Mono.just(p), Product.class))
						.switchIfEmpty(ServerResponse.noContent().build());
				
	
}
	
	
}

package com.vicoga.webflux;

import java.util.Collections;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;


import com.vicoga.webflux.models.documents.Product;
import com.vicoga.webflux.models.services.ProductService;

import reactor.core.publisher.Mono;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringBootWebfluxApiRestApplicationTests {
	
	@Autowired
	private WebTestClient client;
	
	@Autowired
	private ProductService productService;

	@Test
	void ListTest() {
		
		client.get()
		.uri("/api/v2/products")
		.accept(MediaType.APPLICATION_JSON_UTF8)
		.exchange()
		.expectStatus().isOk()
		.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
		.expectBodyList(Product.class)
		.consumeWith(response->{
			List<Product> products=response.getResponseBody();
			Assertions.assertThat(products.size()>0);
		});
		//.hasSize(9);
	}
	
	@Test
	void showTest() {
		Product product= productService.findById("TV Panasonic LCD").block();
		
		client.get()
		.uri("/api/v2/products/{id}",Collections.singletonMap("id", product.getId()))
		.accept(MediaType.APPLICATION_JSON_UTF8)
		.exchange()
		.expectStatus().isOk()
		.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
		.expectBody()
		.jsonPath("$.id").isNotEmpty()
		.jsonPath("$.name").isEqualTo("TV Panasonic LCD");
	}

}

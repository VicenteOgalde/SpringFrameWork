package com.vicoga.webflux;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;


import com.vicoga.webflux.models.documents.Product;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringBootWebfluxApiRestApplicationTests {
	
	@Autowired
	WebTestClient client;

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

}

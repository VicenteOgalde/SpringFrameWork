package com.vicoga.webflux.handler;

import java.io.File;
import java.net.URI;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.vicoga.webflux.models.documents.Product;
import com.vicoga.webflux.models.services.ProductService;

import reactor.core.publisher.Mono;

@Component
public class ProductHandler {

	@Autowired
	private ProductService productService;
	
	@Value("${config.uploads.path}")
	private String path;

	public Mono<ServerResponse> list(ServerRequest request) {

		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(productService.findAll(),
				Product.class);

	}

	public Mono<ServerResponse> show(ServerRequest request) {
		String id = request.pathVariable("id");
		return productService.findById(id).flatMap(
				p -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(Mono.just(p), Product.class))
				.switchIfEmpty(ServerResponse.notFound().build());

	}

	public Mono<ServerResponse> create(ServerRequest request) {
		Mono<Product> product = request.bodyToMono(Product.class);

		return product.flatMap(p -> {
			if (p.getCreateAt() == null) {
				p.setCreateAt(new Date());
			}
			return productService.save(p);
		}).flatMap(p -> ServerResponse.created(URI.create("/api/v2/products".concat(p.getId())))
				.contentType(MediaType.APPLICATION_JSON_UTF8).body(Mono.just(p), Product.class))
				.switchIfEmpty(ServerResponse.noContent().build());

	}

	public Mono<ServerResponse> update(ServerRequest request) {

		Mono<Product> product = request.bodyToMono(Product.class);

		String id = request.pathVariable("id");

		Mono<Product> productToUpdate = productService.findById(id);

		return productToUpdate.zipWith(product, (pToUpdate, p) -> {
			pToUpdate.setName(p.getName());
			pToUpdate.setPrice(p.getPrice());
			pToUpdate.setCategory(p.getCategory());
			return pToUpdate;
		}).flatMap(p -> ServerResponse.created(URI.create("/api/v2/products".concat(p.getId())))
				.contentType(MediaType.APPLICATION_JSON_UTF8).body(productService.save(p), Product.class))
				.switchIfEmpty(ServerResponse.notFound().build());

	}

	public Mono<ServerResponse> delete(ServerRequest request) {

		String id = request.pathVariable("id");

		Mono<Product> productToDelete = productService.findById(id);

		return productToDelete.flatMap(p -> productService.delete(p).then(ServerResponse.noContent().build())
				.switchIfEmpty(ServerResponse.notFound().build()));

	}
	public Mono<ServerResponse> upload(ServerRequest request) {

		String id = request.pathVariable("id");

		return request.multipartData().map(multipart->multipart.toSingleValueMap().get("file"))
				.cast(FilePart.class)
				.flatMap(file-> productService.findById(id).flatMap(p->{
					p.setPhoto(UUID.randomUUID().toString().concat("-").concat(file.filename()
							.replace(" ", "-")
							.replace(":", "")
							.replace("\\", "")));
					return file.transferTo(new File(path+p.getPhoto())).then(productService.save(p));
				})).flatMap(p -> ServerResponse.created(URI.create("/api/v2/products".concat(p.getId())))
						.contentType(MediaType.APPLICATION_JSON_UTF8).body(Mono.just(p), Product.class))
						.switchIfEmpty(ServerResponse.notFound().build());

	}
	

}

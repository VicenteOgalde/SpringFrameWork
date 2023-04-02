package com.vicoga.webflux.controllers;

import java.io.File;
import java.net.URI;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vicoga.webflux.models.documents.Product;
import com.vicoga.webflux.models.services.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Value("${config.uploads.path}")
	private String path;
	
	
	@GetMapping
	public Mono<ResponseEntity<Flux<Product>>> list(){
		return Mono.just(
				ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(productService.findAll()));
	}
	
	@GetMapping("/{id}")
	public Mono<ResponseEntity<Product>> show(@PathVariable String id){
		return productService.findById(id).map(p->ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(p))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Mono<ResponseEntity<Product>> create(@RequestBody Product product){
		if(product.getCreateAt()==null) {
			product.setCreateAt(new Date());
		}
		return productService.save(product).map(
				p->ResponseEntity.created(URI.create("/api/products/".concat(p.getId())))
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(p));
	}
	@PutMapping("/{id}")
	public Mono<ResponseEntity<Product>> update(@RequestBody Product product,@PathVariable String id){
		return productService.findById(id).flatMap(p->{
			p.setName(p.getName());
			p.setPrice(product.getPrice());
			p.setCategory(product.getCategory());
				return productService.save(p);
			
		}).map(p-> ResponseEntity.created(URI.create("/api/products/".concat(p.getId())))
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(p))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public Mono<ResponseEntity<Void>> delete(@PathVariable String id){
		return productService.findById(id).flatMap(
				p-> productService.delete(p).then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT))))
				.defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping("/upload/{id}")
	public Mono<ResponseEntity<Product>> upload(@PathVariable String id,@RequestPart FilePart file){
		
		return productService.findById(id).flatMap(p->{
			p.setPhoto(UUID.randomUUID().toString()
					.concat("-")
					.concat(file.filename()
							.replace(" ", "")
							.replace(":", "")
							.replace("\\", "")));
			return file.transferTo(new File(path.concat(p.getPhoto())))
					.then(productService.save(p));
		}).map(p->ResponseEntity.ok(p))
				.defaultIfEmpty(ResponseEntity.notFound().build());
				
	}
	
	

}

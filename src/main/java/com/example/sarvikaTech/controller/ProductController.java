package com.example.sarvikaTech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sarvikaTech.model.Product;
import com.example.sarvikaTech.service.ProductService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService prodService;
	
	@GetMapping
	public List<Product> getAllProducts(){
		return prodService.findAll();
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id) {
		return prodService.findById(id);
	}
	
	@PostMapping
	public Product createProduct(@Valid @RequestBody Product product) {
		return prodService.save(product);
	}
	
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable Long id, @Valid @RequestBody Product product) {
		return prodService.update(id, product);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id) {
		prodService.delete(id);
	}
}

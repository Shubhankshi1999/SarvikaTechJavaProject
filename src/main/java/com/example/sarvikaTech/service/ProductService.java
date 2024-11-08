package com.example.sarvikaTech.service;

import java.util.List;

import com.example.sarvikaTech.model.Product;

public interface ProductService {

	List<Product> findAll();
    Product findById(Long id);
    Product save(Product product); // Ensure this method is present and correctly defined
    Product update(Long id, Product product);
    void delete(Long id);
}

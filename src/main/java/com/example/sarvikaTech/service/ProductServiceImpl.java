package com.example.sarvikaTech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sarvikaTech.exception.ResourceNotFoundException;
import com.example.sarvikaTech.model.Product;
import com.example.sarvikaTech.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository prodRepo;
	
	@Override
	public List<Product> findAll(){
		return prodRepo.findAll();
	}
	
	@Override
	public Product findById(Long id) {
		return prodRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product not found"));
	}
	
	@Override
	public Product save(Product product) {
		return prodRepo.save(product);
	}
	
	@Override
	public Product update(Long id, Product product) {
		Product existingProd = findById(id);
		existingProd.setName(product.getName());
		existingProd.setDescription(product.getDescription());
		existingProd.setPrice(product.getPrice());
	    return prodRepo.save(existingProd);
	}
	
	@Override 
	public void delete(Long id) {
		prodRepo.deleteById(id);
    }
}

package com.example.sarvikaTech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sarvikaTech.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}

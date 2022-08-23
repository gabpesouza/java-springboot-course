package com.udemy.coursespringboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.coursespringboot.entities.Product;
import com.udemy.coursespringboot.repositories.ProductRepository;
@Service
public class ProductService {
	@Autowired
	private ProductRepository ProductRepository;
	
	
	public List<Product> findAll(){
		return ProductRepository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> Product = ProductRepository.findById(id);
		return Product.get();
		
	}
	
	
	

}

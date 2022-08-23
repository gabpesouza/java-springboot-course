package com.udemy.coursespringboot.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.coursespringboot.entities.Product;
import com.udemy.coursespringboot.services.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductResource {
	@Autowired
	private ProductService ProductService;

	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		return ResponseEntity.ok(ProductService.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		return ResponseEntity.ok(ProductService.findById(id));
	}
	
	

}

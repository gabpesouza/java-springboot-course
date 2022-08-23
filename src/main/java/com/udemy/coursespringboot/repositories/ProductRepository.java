package com.udemy.coursespringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.coursespringboot.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}

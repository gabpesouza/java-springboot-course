package com.udemy.coursespringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.coursespringboot.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}

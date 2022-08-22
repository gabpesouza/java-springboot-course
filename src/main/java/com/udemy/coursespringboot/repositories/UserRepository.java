package com.udemy.coursespringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.coursespringboot.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	
	
	

}

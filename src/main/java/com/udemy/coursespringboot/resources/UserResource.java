package com.udemy.coursespringboot.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.coursespringboot.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User p = new User("Gabriel", "gabriel@gmail", 2L, "99999", "12345");
		return ResponseEntity.ok(p);
		
		
	}

	




}

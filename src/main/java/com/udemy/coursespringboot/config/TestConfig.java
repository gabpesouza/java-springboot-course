package com.udemy.coursespringboot.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.udemy.coursespringboot.entities.User;
import com.udemy.coursespringboot.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository user;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User("Paulo", "paulo@gmail", 2L, "9999", "123");
		User u2 = new User("Saulo", "saulo@gmail", 3L, "8888", "321");
		
		user.saveAll(Arrays.asList(u1,u2));
		
	}
	
	

}

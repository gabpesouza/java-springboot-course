package com.udemy.coursespringboot.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.udemy.coursespringboot.entities.Order;
import com.udemy.coursespringboot.entities.User;
import com.udemy.coursespringboot.entities.enums.OrderStatus;
import com.udemy.coursespringboot.repositories.OrderRepository;
import com.udemy.coursespringboot.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {  //Classe seeding do repository
	
	@Autowired
	private UserRepository user;
	@Autowired
	private OrderRepository order;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User("Paulo", "paulo@gmail",null, "9999", "123");
		User u2 = new User("Saulo", "saulo@gmail",null, "8888", "321");
		
		Order o1 = new Order(null, Instant.parse("2009-05-23T16:50:30Z"),OrderStatus.CANCELED, u2);
		Order o2 = new Order(null,Instant.parse("2009-04-10T18:20:20Z"),OrderStatus.DELIVERED,u2);
		Order o3 = new Order(null,Instant.parse("2011-02-12T21:30:00Z"),OrderStatus.PAID,u1);
		
		user.saveAll(Arrays.asList(u1,u2));
		order.saveAll(Arrays.asList(o1,o2,o3));
		
		
		
	}
	
	

}

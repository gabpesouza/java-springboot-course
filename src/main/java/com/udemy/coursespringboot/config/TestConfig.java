package com.udemy.coursespringboot.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.udemy.coursespringboot.entities.Category;
import com.udemy.coursespringboot.entities.Order;
import com.udemy.coursespringboot.entities.OrderItem;
import com.udemy.coursespringboot.entities.Payment;
import com.udemy.coursespringboot.entities.Product;
import com.udemy.coursespringboot.entities.User;
import com.udemy.coursespringboot.entities.enums.OrderStatus;
import com.udemy.coursespringboot.repositories.CategoryRepository;
import com.udemy.coursespringboot.repositories.OrderItemRepository;
import com.udemy.coursespringboot.repositories.OrderRepository;
import com.udemy.coursespringboot.repositories.ProductRepository;
import com.udemy.coursespringboot.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {  //Classe seeding do repository
	
	@Autowired
	private UserRepository user;
	@Autowired
	private OrderRepository order;
	@Autowired
	private CategoryRepository category;
	@Autowired
	private ProductRepository product;
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	
	
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null,"Paulo", "paulo@gmail", "9999", "123");
		User u2 = new User(null,"Saulo", "saulo@gmail", "8888", "321");
		
		Order o1 = new Order(null, Instant.parse("2009-05-23T16:50:30Z"),OrderStatus.CANCELED, u2);
		Order o2 = new Order(null,Instant.parse("2009-04-10T18:20:20Z"),OrderStatus.DELIVERED,u2);
		Order o3 = new Order(null,Instant.parse("2011-02-12T21:30:00Z"),OrderStatus.PAID,u1);
		
		Category c1 = new Category(null, "Eletronics");
		Category c2 = new Category(null, "Computer");
		Category c3 = new Category(null, "Books");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 

		
		
		user.saveAll(Arrays.asList(u1,u2));
		order.saveAll(Arrays.asList(o1,o2,o3));
		category.saveAll(Arrays.asList(c1,c2,c3));
		product.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		p1.getCategories().add(c3);
		p2.getCategories().add(c1);
		p3.getCategories().add(c2);
		p4.getCategories().add(c2);
		p5.getCategories().add(c3);
		
		product.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		OrderItem oi1 = new OrderItem(o1,p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1,p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2,p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3,p5, 2, p5.getPrice());
		
	
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
		
		Payment payment = new Payment(null,Instant.parse("2009-05-23T18:50:30Z"),o1);
		o1.setPayment(payment);
		
		order.save(o1);
		
		
		
	}
	
	

}

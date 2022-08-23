package com.udemy.coursespringboot.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.coursespringboot.entities.Order;
import com.udemy.coursespringboot.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	
	@Autowired
	OrderService us;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order> list;
		list = us.findAll();
		return ResponseEntity.ok(list);
		
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		return ResponseEntity.ok(us.findById(id));
	}

	




}

package com.udemy.coursespringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.coursespringboot.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}

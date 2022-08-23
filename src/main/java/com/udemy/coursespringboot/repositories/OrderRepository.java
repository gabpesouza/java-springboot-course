package com.udemy.coursespringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.coursespringboot.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}

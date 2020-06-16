package com.example.userdetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.userdetails.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}

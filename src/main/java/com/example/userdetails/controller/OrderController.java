package com.example.userdetails.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.userdetails.entity.Order;

@RestController
public class OrderController {

	@Autowired
	com.example.userdetails.repository.OrderRepository orderRepo;

	@GetMapping(value = "/orders/{orderid}")
	public ResponseEntity<Order> getOrder(@PathVariable("orderid") Long orderId) {

		Optional<Order> order = orderRepo.findById(orderId);
		if (order.isPresent()) {
			return new ResponseEntity<Order>(order.get(), HttpStatus.OK);
		}

		return null;

	}

	@PostMapping(value = "/orders")
	public ResponseEntity<Order> addOrder(@RequestBody Order order) {

		Order savedOrder = orderRepo.save(order);

		return new ResponseEntity<Order>(savedOrder, HttpStatus.CREATED);

	}

	@GetMapping(value = "/orders")
	public List<Order> getOrders() {

		List<Order> orders = orderRepo.findAll();

		return orders;

	}

}

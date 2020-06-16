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
import com.example.userdetails.entity.User;

@RestController
public class UserController {

	@Autowired
	com.example.userdetails.repository.UserRepository userRepo;

	@GetMapping(value = "/users/{userid}")
	public ResponseEntity<User> getUser(@PathVariable("userid") Long userid) {

		Optional<User> user = userRepo.findById(userid);
		if (user.isPresent()) {
			user.get().setOrders(null);
			return new ResponseEntity<User>(user.get(), HttpStatus.OK);
		}

		return null;

	}
	
	@GetMapping(value = "/userorders/{userid}")
	public ResponseEntity<User> getUserOders(@PathVariable("userid") Long userid) {

		Optional<User> user = userRepo.findById(userid);
		if (user.isPresent()) {
			return new ResponseEntity<User>(user.get(), HttpStatus.OK);
		}

		return null;

	}

	@PostMapping(value = "/users")
	public ResponseEntity<User> getUser(@RequestBody User user) {

		User savedUser = userRepo.save(user);

		return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);

	}

	@GetMapping(value = "/users")
	public List<User> getUsers() {

		List<User> users = userRepo.findAll();

		return users;

	}

}

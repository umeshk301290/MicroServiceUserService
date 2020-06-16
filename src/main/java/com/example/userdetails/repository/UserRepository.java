package com.example.userdetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.userdetails.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
	

}

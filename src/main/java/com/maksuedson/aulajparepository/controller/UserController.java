package com.maksuedson.aulajparepository.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maksuedson.aulajparepository.entities.User;
import com.maksuedson.aulajparepository.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserRepository repo;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> result = repo.findAll();
		return ResponseEntity.ok(result);
	}
}

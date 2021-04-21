package com.maksuedson.aulajparepository.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/page")
	public ResponseEntity<Page<User>> findAll(Pageable pageable){
		Page<User> result = repo.findAll(pageable);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping(value = "/search-salary")
	public ResponseEntity<Page<User>> searchBySalary(
			@RequestParam(defaultValue = "0") Double minSalary, 
			@RequestParam(defaultValue = "100000000000")Double maxSalary, 
			Pageable pageable){
		Page<User> result = repo.searchSalary(minSalary, maxSalary, pageable);		
		return ResponseEntity.ok(result);		
	}
	
	@GetMapping(value = "/search-name")
	public ResponseEntity<Page<User>> searchByName(
			@RequestParam(defaultValue = "") String name, 
			Pageable pageable){
		Page<User> result = repo.searchName(name, pageable);		
		return ResponseEntity.ok(result);		
	}
}

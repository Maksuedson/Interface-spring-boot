package com.maksuedson.aulajparepository.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maksuedson.aulajparepository.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

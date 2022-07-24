package com.wipro.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.springboot.Entity.Users;
 
public interface UsersRepository extends JpaRepository<Users, Integer> {
 
}
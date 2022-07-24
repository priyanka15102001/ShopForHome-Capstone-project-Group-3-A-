package com.wipro.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.springboot.Entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {
	 
	}


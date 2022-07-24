package com.wipro.springboot.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.springboot.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	 
	}

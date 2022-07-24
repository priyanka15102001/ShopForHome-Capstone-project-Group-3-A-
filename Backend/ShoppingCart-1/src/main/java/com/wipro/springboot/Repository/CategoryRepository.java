package com.wipro.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.springboot.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	 
	}


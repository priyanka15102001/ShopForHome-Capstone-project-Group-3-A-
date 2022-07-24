package com.wipro.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.springboot.Entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	 
	}


package com.wipro.springboot.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.springboot.Entity.SalesLog;

public interface SalesLogRepository extends JpaRepository<SalesLog, Integer> {
	 
	}

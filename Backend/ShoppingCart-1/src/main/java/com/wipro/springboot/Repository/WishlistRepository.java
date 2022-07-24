package com.wipro.springboot.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.springboot.Entity.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {
	 
	}

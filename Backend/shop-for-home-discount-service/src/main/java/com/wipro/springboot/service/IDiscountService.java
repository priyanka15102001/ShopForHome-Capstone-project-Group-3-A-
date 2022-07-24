package com.wipro.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.wipro.springboot.entity.Discount;

public interface IDiscountService {

	Discount createCoupon(String code);

	Page<Discount> findAll(PageRequest request);

	void deleteCoupon(String code);

	List<Discount> findAll();

}

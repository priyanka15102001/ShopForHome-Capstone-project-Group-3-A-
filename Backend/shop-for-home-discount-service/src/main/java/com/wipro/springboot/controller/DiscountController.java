package com.wipro.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.springboot.entity.Discount;
import com.wipro.springboot.service.IDiscountService;

@CrossOrigin
@RestController
public class DiscountController {

	@Autowired
	IDiscountService discountService;

	@PostMapping("/add/coupon/{code}")
	public ResponseEntity<Discount> createCoupon(@PathVariable("code") String code) {
		return ResponseEntity.ok(discountService.createCoupon(code));
	}

	@GetMapping("/coupon/list")
	public Page<Discount> orderList(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {
		PageRequest request = PageRequest.of(page - 1, size);
		Page<Discount> discountPage;
		discountPage = discountService.findAll(request);
		return discountPage;
	}

	@GetMapping("/coupon/alllist")
	public List<Discount> orderList() {
		return discountService.findAll();
	}

	@DeleteMapping("/delete/coupon/{code}")
	public ResponseEntity<Discount> deleteCoupon(@PathVariable("code") String code) {
		discountService.deleteCoupon(code);
		return ResponseEntity.ok(null);
	}

}

package com.hcl.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerce.service.UserOrderService;

@RestController
@RequestMapping("orders")
public class UserOrderController {
	
	@Autowired
	UserOrderService userOrderService;
	
	@PostMapping
	public ResponseEntity<String> saveOrder(@RequestParam Integer productStoreId, @RequestParam Integer userId){
		if (productStoreId == null) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("productStoreId is null");
		} else if (userId == null) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("userId is null");
		} else {
			String message = userOrderService.saveOrder(productStoreId, userId);
			return ResponseEntity.ok().body(message);
		}
	}

}

package com.hcl.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerce.service.ProductStoreService;

@RestController
@RequestMapping("/productstores")
public class ProductStoreController {

	@Autowired
	ProductStoreService productStoreService;

	@GetMapping("/{productId}")
	public ResponseEntity<Object> getStoresByproductId(@PathVariable("productId") Integer productId) {
		if (productId == null) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("productId is null");
		} else {
			return ResponseEntity.ok().body(productStoreService.getByProductId(productId));
		}
	}
}

package com.hcl.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerce.model.Product;
import com.hcl.ecommerce.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("")
	public ResponseEntity<String> saveProduct(@RequestParam String productName, @RequestParam String productDescription) {
		if (productName == null) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("product name is null");
		} else if (productDescription == null) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("productDescription is null");
		} else {
			String message = productService.saveProduct(productName, productDescription);
			return ResponseEntity.ok().body(message);
		}
	}

	@GetMapping("/{productName}")
	public ResponseEntity<Object> searchProduct(@PathVariable("productName") String productName) {
		if (productName == null) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("product name is null");
		}else {
			List<Product> products = productService.searchProduct(productName);
			return ResponseEntity.ok().body(products);
		}
	}

}

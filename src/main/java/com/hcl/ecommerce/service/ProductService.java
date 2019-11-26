package com.hcl.ecommerce.service;

import java.util.List;

import com.hcl.ecommerce.model.Product;

public interface ProductService {
	
	String saveProduct(String productName, String productDescription);
	List<Product> searchProduct(String productName);
}

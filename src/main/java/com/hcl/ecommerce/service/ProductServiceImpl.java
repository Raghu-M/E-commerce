package com.hcl.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.model.Product;
import com.hcl.ecommerce.repository.ProductRepository;

/**
 * class for product service implementation.
 *
 * @author Raghu M
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	/**
	 * save the product entity.
	 *
	 * @param productName and productDescription and should not be null.
	 * @return String after saving the product.
	 * @throws none.
	 */
	@Override
	public String saveProduct(String productName, String productDescription) {
		Product product = new Product();
		product.setProductDescription(productDescription);
		product.setProductName(productName);
		productRepository.save(product);
		return "product saved";
	}

	/**
	 * get the list of products based on the partial name.
	 *
	 * @param partial name of the product.
	 * @return list of products.
	 * @throws none.
	 */
	@Override
	public List<Product> searchProduct(String productName) {
		return productRepository.findByProductNameContaining(productName);
	}

}

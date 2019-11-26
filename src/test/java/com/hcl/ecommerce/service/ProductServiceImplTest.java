package com.hcl.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ecommerce.model.Product;
import com.hcl.ecommerce.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ProductServiceImplTest {
	
	@Mock
	ProductRepository productRepository;
	
	@InjectMocks
	ProductServiceImpl productServiceImpl;
	
	@Test
	public void testSaveProductForSuccess() {
		Product product = new Product();
		String expected = "product saved";
		Mockito.when(productRepository.save(product)).thenReturn(product);
		String actual = productServiceImpl.saveProduct("phone", "anything");
		assertEquals(expected, actual);
	}
	
	@Test
	public void testsearchProductSuccess() {
		List<Product> expected = new ArrayList<>();
		Mockito.when(productRepository.findByProductNameContaining("asb")).thenReturn(new ArrayList<Product>());
		List<Product> actual = productServiceImpl.searchProduct("asb");
		assertEquals(expected, actual);
	}

}

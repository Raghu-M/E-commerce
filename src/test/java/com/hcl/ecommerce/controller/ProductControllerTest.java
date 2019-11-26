package com.hcl.ecommerce.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import com.hcl.ecommerce.model.Product;
import com.hcl.ecommerce.service.ProductService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ProductControllerTest {
	
	@Mock
	ProductService productService;
	
	@InjectMocks
	ProductController productController;
	
	@Test
	public void testSaveProductForNull() {
		
		String actual = productController.saveProduct(null, "anything").getBody();
		assertEquals("product name is null", actual);

		actual = productController.saveProduct("anything", null).getBody();
		assertEquals("productDescription is null", actual);
	}
	
	@Test
	public void testSaveProductForSuccess() {
		
		HttpStatus expected = HttpStatus.OK;
		Mockito.when(productService.saveProduct("phone", "anything")).thenReturn("success");
		HttpStatus actual = productController.saveProduct("phone", "naything").getStatusCode();
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void testSearchProductForNull() {
		
		HttpStatus expected = HttpStatus.NOT_ACCEPTABLE;
		HttpStatus actual = productController.searchProduct(null).getStatusCode();
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void testSearchProductForSuccess() {

		HttpStatus expected = HttpStatus.OK;
		Mockito.when(productService.searchProduct("rag")).thenReturn(new ArrayList<Product>());
		HttpStatus actual = productController.searchProduct("rag").getStatusCode();
		assertEquals(expected, actual);
		
	}

}

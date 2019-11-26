package com.hcl.ecommerce.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ecommerce.dto.ResponseStoreDto;
import com.hcl.ecommerce.service.ProductStoreService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ProductStoreControllerTest {
	
	@Mock
	ProductStoreService productStoreService;
	
	@InjectMocks
	ProductStoreController productStoreController;
	
	
	
	@Test
	public void testGetStoresByproductIdForNull() {
		String expected = "productId is null";
		String actual = (String) productStoreController.getStoresByproductId(null).getBody();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetStoresByproductIdForSuccess() {
		List<ResponseStoreDto> expected = new ArrayList<ResponseStoreDto>();
		Mockito.when(productStoreService.getByProductId(1)).thenReturn(expected);
		@SuppressWarnings("unchecked")
		List<ResponseStoreDto> actual = (List<ResponseStoreDto>) productStoreController.getStoresByproductId(1).getBody();
		assertEquals(expected, actual);
	}

}

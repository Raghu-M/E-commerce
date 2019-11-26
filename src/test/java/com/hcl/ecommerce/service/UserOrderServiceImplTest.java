package com.hcl.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ecommerce.model.ProductStore;
import com.hcl.ecommerce.model.UserOrder;
import com.hcl.ecommerce.repository.ProductStoreRepository;
import com.hcl.ecommerce.repository.UserOrderRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserOrderServiceImplTest {
	
	@Mock
	UserOrderRepository userOrderRepository;
	
	@Mock
	ProductStoreRepository productStoreRepository;
	
	@InjectMocks
	UserOrderServiceImpl userOrderServiceImpl;
	
	@Test
	public void testsaveOrderForNull() {
		
		String expected = "productStore not found";
		Mockito.when(productStoreRepository.findById(1)).thenReturn(Optional.of(new ProductStore()));
		String actual = userOrderServiceImpl.saveOrder(2, 3);
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void testsaveOrderForSuccess() {
		
		String expected = "order saved successfully";
		Mockito.when(productStoreRepository.findById(1)).thenReturn(Optional.of(new ProductStore()));
		Mockito.when(userOrderRepository.save(new UserOrder())).thenReturn(new UserOrder());
		String actual = userOrderServiceImpl.saveOrder(1, 1);
		assertEquals(expected, actual);
		
	}
}

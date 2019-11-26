package com.hcl.ecommerce.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import com.hcl.ecommerce.service.UserOrderService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserOrderControllerTest {
	
	@InjectMocks
	UserOrderController userOrderController;

	@Mock
	UserOrderService userOrderService;
	
	@Test
	public void testSaveOrderForNull() {

		HttpStatus expected = HttpStatus.NOT_ACCEPTABLE;
		HttpStatus actual = userOrderController.saveOrder(null, 1).getStatusCode();
		assertEquals(expected, actual);
	
		actual = userOrderController.saveOrder(1, null).getStatusCode();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSaveOrderForSuccess() {

		HttpStatus expected = HttpStatus.OK;
		Mockito.when(userOrderService.saveOrder(1, 1)).thenReturn("success");
		HttpStatus actual = userOrderController.saveOrder(1, 1).getStatusCode();
		assertEquals(expected, actual);

	}

}

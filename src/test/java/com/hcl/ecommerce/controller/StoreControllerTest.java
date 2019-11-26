package com.hcl.ecommerce.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import com.hcl.ecommerce.dto.RequestStoreDto;
import com.hcl.ecommerce.service.StoreService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class StoreControllerTest {

	@Mock
	StoreService StoreService;

	@InjectMocks
	StoreController storeController;

	@Test
	public void testSaveStoreForNull() {

		RequestStoreDto requestStoreDto = new RequestStoreDto();

		HttpStatus expected = HttpStatus.NOT_ACCEPTABLE;
		HttpStatus actual = storeController.saveStore(requestStoreDto).getStatusCode();
		assertEquals(expected, actual);

		requestStoreDto.setStoreName("storeNamke");
		actual = storeController.saveStore(requestStoreDto).getStatusCode();
		assertEquals(expected, actual);

		requestStoreDto.setContactNumber("78564354");
		actual = storeController.saveStore(requestStoreDto).getStatusCode();
		assertEquals(expected, actual);

	}

	@Test
	public void testSaveStoreForSuccess() {

		RequestStoreDto requestStoreDto = new RequestStoreDto();
		requestStoreDto.setStoreName("storeNamke");
		requestStoreDto.setContactNumber("78564354");
		requestStoreDto.setAddress("bangalore");
		HttpStatus expected = HttpStatus.OK;
		Mockito.when(StoreService.saveStore(requestStoreDto)).thenReturn("success");
		HttpStatus actual = storeController.saveStore(requestStoreDto).getStatusCode();
		assertEquals(expected, actual);
	}

}

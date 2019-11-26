package com.hcl.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ecommerce.dto.RequestStoreDto;
import com.hcl.ecommerce.model.Store;
import com.hcl.ecommerce.repository.StoreRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class StoreServiceImplTest {
	
	@Mock
	StoreRepository storeRepository;
	
	@InjectMocks
	StoreServiceImpl storeServiceImpl;
	
	@Test
	public void testSaveProductForSuccess() {
		Store store = new Store();
		String expected = "store saved";
		Mockito.when(storeRepository.save(store)).thenReturn(store);
		String actual = storeServiceImpl.saveStore(new RequestStoreDto());
		assertEquals(expected, actual);
	}
}

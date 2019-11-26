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

import com.hcl.ecommerce.dto.ResponseStoreDto;
import com.hcl.ecommerce.model.ProductStore;
import com.hcl.ecommerce.repository.ProductStoreRepository;
import com.hcl.ecommerce.repository.StoreReviewRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ProductStoreServiceImplTest {
	
	@Mock
	ProductStoreRepository productStoreRepository;
	
	@Mock
	StoreReviewRepository storeReviewRepository;
	
	@InjectMocks
	ProductStoreServiceImpl productStoreServiceImpl;
	
	@Test
	public void testGetByProductId() {
		ProductStore productStore = new ProductStore();
		productStore.setProductId(1);
		productStore.setProductPrice(100.0);
		productStore.setProductStoreId(1);
		productStore.setStoreId(1);
		List<ProductStore> productStores = new ArrayList<ProductStore>();
		productStores.add(productStore);
		
		ResponseStoreDto responseStoreDto = new ResponseStoreDto();
		responseStoreDto.setProductId(1);
		responseStoreDto.setProductPrice(100.0);
		responseStoreDto.setProductStoreId(1);
		responseStoreDto.setRating(4.4);
		responseStoreDto.setStoreId(1);
		List<ResponseStoreDto> expected = new ArrayList<ResponseStoreDto>();
		expected.add(responseStoreDto);
		
		Mockito.when(productStoreRepository.findByProductId(1)).thenReturn(productStores);
		Mockito.when(storeReviewRepository.findAverageRatingByStoreId(productStore.getStoreId())).thenReturn(4.4);
		List<ResponseStoreDto> actual = productStoreServiceImpl.getByProductId(1);
		assertEquals(expected.get(0).getRating(), actual.get(0).getRating());
	}

}

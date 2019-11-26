package com.hcl.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.dto.ResponseStoreDto;
import com.hcl.ecommerce.model.ProductStore;
import com.hcl.ecommerce.repository.ProductStoreRepository;
import com.hcl.ecommerce.repository.StoreReviewRepository;

/**
 * class for product Store service implementation.
 *
 * @author Raghu
 */
@Service
public class ProductStoreServiceImpl implements ProductStoreService {

	@Autowired
	ProductStoreRepository productStoreRepository;

	@Autowired
	StoreReviewRepository storeReviewRepository;

	/**
	 * get the list of stores based on the productId where the product is present.
	 *
	 * @param Integer productId.
	 * @return list of stores.
	 * @throws none.
	 */
	@Override
	public List<ResponseStoreDto> getByProductId(Integer productId) {
		List<ProductStore> productStores = productStoreRepository.findByProductId(productId);
		List<ResponseStoreDto> responseStoreDtos = new ArrayList<>();
		for (ProductStore productStore : productStores) {
			ResponseStoreDto responseStoreDto = new ResponseStoreDto();
			responseStoreDto.setProductId(productStore.getProductId());
			responseStoreDto.setProductStoreId(productStore.getProductStoreId());
			responseStoreDto.setStoreId(productStore.getStoreId());
			responseStoreDto.setProductPrice(productStore.getProductPrice());
			responseStoreDto.setRating(storeReviewRepository.findAverageRatingByStoreId(productStore.getStoreId()));
			responseStoreDtos.add(responseStoreDto);
		}

		return responseStoreDtos;
	}

}

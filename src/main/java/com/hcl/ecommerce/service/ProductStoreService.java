package com.hcl.ecommerce.service;

import java.util.List;

import com.hcl.ecommerce.dto.ResponseStoreDto;

public interface ProductStoreService {
	
	List<ResponseStoreDto> getByProductId(Integer productId);

}

package com.hcl.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.dto.RequestStoreDto;
import com.hcl.ecommerce.model.Store;
import com.hcl.ecommerce.repository.StoreRepository;
/**
 * class for user Store service implementation.
 *
 * @author Raghu
 */
@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	StoreRepository storeRepository;

	/**
	 * save the store entity.
	 *
	 * @param requestStoreDto entity.
	 * @return string store saved.
	 * @throws none.
	 */
	@Override
	public String saveStore(RequestStoreDto requestStoreDto) {
		Store store = new Store();
		store.setStoreName(requestStoreDto.getStoreName());
		store.setContactNumber(requestStoreDto.getContactNumber());
		store.setAddress(requestStoreDto.getAddress());
		storeRepository.save(store);
		return "store saved";

	}

}

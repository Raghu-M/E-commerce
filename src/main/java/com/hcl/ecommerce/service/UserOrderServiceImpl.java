package com.hcl.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.model.ProductStore;
import com.hcl.ecommerce.model.UserOrder;
import com.hcl.ecommerce.repository.ProductStoreRepository;
import com.hcl.ecommerce.repository.UserOrderRepository;

/**
 * class for order service implementation.
 *
 * @author Raghu
 */
@Service
public class UserOrderServiceImpl implements UserOrderService {

	@Autowired
	UserOrderRepository userOrderRepository;

	@Autowired
	ProductStoreRepository productStoreRepository;

	/**
	 * save the order entity.
	 *
	 * @param productId and userId and should not be null.
	 * @return String (order saved successfully) if fails then(productStore not
	 *         found).
	 * @throws none.
	 */
	@Override
	public String saveOrder(Integer productStoreId, Integer userId) {
		ProductStore productStore = productStoreRepository.findById(productStoreId).orElse(null);

		if (productStore != null) {
			UserOrder userOrder = new UserOrder();
			userOrder.setProductId(productStore.getProductId());
			userOrder.setProductPrice(productStore.getProductPrice());
			userOrder.setStoreId(productStore.getStoreId());
			userOrder.setUserId(userId);
			userOrderRepository.save(userOrder);
			return "order saved successfully";
		}
		return "productStore not found";
	}

}

package com.hcl.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductStore {

	@Id
	private Integer productStoreId;
	private Integer productId;
	private Integer storeId;
	private Double productPrice;

	public Integer getProductStoreId() {
		return productStoreId;
	}

	public void setProductStoreId(Integer productStoreId) {
		this.productStoreId = productStoreId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

}

package com.hcl.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StoreReview {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer storeReviewId;
	private Integer userId;
	private Integer storeId;
	private float rating;

	public Integer getStoreReviewId() {
		return storeReviewId;
	}

	public void setStoreReviewId(Integer storeReviewId) {
		this.storeReviewId = storeReviewId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

}

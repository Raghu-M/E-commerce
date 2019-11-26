package com.hcl.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.ecommerce.model.StoreReview;

@Repository
public interface StoreReviewRepository extends JpaRepository<StoreReview, Integer> {
	
	@Query("SELECT avg(rating) from StoreReview where storeId = ?1")
	Double findAverageRatingByStoreId(Integer storeId);

}

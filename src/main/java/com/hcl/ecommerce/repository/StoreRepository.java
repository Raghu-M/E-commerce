package com.hcl.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ecommerce.model.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {

}

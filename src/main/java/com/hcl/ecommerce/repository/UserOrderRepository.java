package com.hcl.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ecommerce.model.UserOrder;

@Repository
public interface UserOrderRepository extends JpaRepository<UserOrder, Integer> {

}

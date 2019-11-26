package com.hcl.ecommerce.service;

public interface UserService {

	boolean authenticate(Integer userId, String password);
}

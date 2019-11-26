package com.hcl.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.model.User;
import com.hcl.ecommerce.repository.UserRepository;

/**
 * class for user service implementation.
 *
 * @author Raghu
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	/**
	 * authenticates the user by checking whether it is present in the user entity.
	 *
	 * @param userId and password and should not be null.
	 * @return boolean after authenticating the user.
	 * @throws none.
	 */
	@Override
	public boolean authenticate(Integer userId, String password) {
		User user1 = userRepository.findById(userId).orElse(null);
		return user1 != null && password.equals(user1.getPassword());
	}

}

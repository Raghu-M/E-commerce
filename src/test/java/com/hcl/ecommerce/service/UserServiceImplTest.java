package com.hcl.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ecommerce.model.User;
import com.hcl.ecommerce.repository.UserRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserServiceImplTest {
	
	@Mock
	UserRepository userRepository;
	
	@InjectMocks
	UserServiceImpl userServiceImpl;
	
	@Test
	public void testAuthenticateForNull() {
		
		boolean expected = false;
		Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(new User()));
		boolean actual = userServiceImpl.authenticate(2, "asdf");
		assertEquals(expected, actual);
	}
	
	@Test
	public void testAuthenticateForFailure() {
		
		boolean expected = false;
		Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(new User()));
		boolean actual = userServiceImpl.authenticate(1, "asdf");
		assertEquals(expected, actual);
	}
	
	@Test
	public void testAuthenticateForSuccess() {
		
		User user = new User();
		user.setPassword("asdf");
		
		boolean expected = true;
		Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(user));
		boolean actual = userServiceImpl.authenticate(1, "asdf");
		assertEquals(expected, actual);
	}

}

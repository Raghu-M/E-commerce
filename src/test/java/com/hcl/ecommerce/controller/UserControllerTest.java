package com.hcl.ecommerce.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ecommerce.service.UserService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserControllerTest {

	@InjectMocks
	UserController userController;

	@Mock
	UserService userService;

	@Test
	public void testAuthenticateForNull() {

		String actual = userController.authenticate(null, "jerry").getBody();
		assertEquals("userId is missing", actual);

		actual = userController.authenticate(1, null).getBody();
		assertEquals("password is missing", actual);

	}

	@Test
	public void testAuthenticateForSuccess() {

		Mockito.when(userService.authenticate(10, "jerry")).thenReturn(true);
		String actual = userController.authenticate(10, "jerry").getBody();
		assertEquals("successfully logged in", actual);
	}

	@Test
	public void testAuthenticateForFailure() {

		Mockito.when(userService.authenticate(1, "jerry")).thenReturn(false);
		String actual = userController.authenticate(1, "jerry").getBody();
		assertEquals("userName and password did not match", actual);

	}

}

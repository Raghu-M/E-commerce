package com.hcl.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerce.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/authenticate")
	public ResponseEntity<String> authenticate(@RequestParam Integer userId, @RequestParam String password) {
		if (userId == null) {
			return ResponseEntity.ok().body("userId is missing");
		} else if (password == null) {
			return ResponseEntity.ok().body("password is missing");
		} else {
			boolean flag = userService.authenticate(userId, password);
			if (flag) {
				return ResponseEntity.ok().body("successfully logged in");
			} else {
				return ResponseEntity.ok().body("userName and password did not match");
			}

		}

	}

}

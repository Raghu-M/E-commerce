package com.hcl.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerce.dto.RequestStoreDto;
import com.hcl.ecommerce.service.StoreService;

@RestController
@RequestMapping("/stores")
public class StoreController {
	
	@Autowired
	StoreService storeService;

	@PostMapping("")
	public ResponseEntity<String> saveStore(@RequestBody RequestStoreDto requestStoreDto) {
		if (requestStoreDto.getStoreName() == null) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("store name is null");
		} else if (requestStoreDto.getContactNumber() == null) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("contact number is null");
		}else if (requestStoreDto.getAddress() == null) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("address is null");
		} else {
			String message = storeService.saveStore(requestStoreDto);
			return ResponseEntity.ok().body(message);
		}
		
	}
	
	

}

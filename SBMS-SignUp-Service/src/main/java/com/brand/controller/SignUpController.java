package com.brand.controller;

import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brand.model.SignUpModel;

@RestController
@RequestMapping("/api")
public class SignUpController {
	
	private final org.slf4j.Logger logger = LoggerFactory.getLogger(SignUpController.class);
	
	@PostMapping("/signUp")
	public ResponseEntity<?> signUp(@RequestBody SignUpModel signUpModel) {
        logger.info("Signup request received: {}", signUpModel);
		return null;
	}

}

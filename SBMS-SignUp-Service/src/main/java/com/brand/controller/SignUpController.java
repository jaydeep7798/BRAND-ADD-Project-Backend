package com.brand.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.brand.dao.SignUpRepository;
import com.brand.entity.SignUpEntity;
import com.brand.model.SignUpModel;
import com.brand.common.dto.*;
import com.brand.service.SignUpService;

@RestController
@RequestMapping("/api")
public class SignUpController {
	
	private final org.slf4j.Logger logger = LoggerFactory.getLogger(SignUpController.class);
	
	@Autowired
	private SignUpService signUpService;
	
	@Autowired
	private SignUpRepository signUpRepository;
	
	@PostMapping("/signUp")
	public SignUpResponse signUp(@RequestBody SignUpModel signUpModel) {
        logger.info("Signup request received: {}", signUpModel);
        SignUpResponse signResponse = this.signUpService.signup(signUpModel);
		return signResponse;
	}

	@GetMapping("/{email}")
	public SignUpResponse getUserByEmail(@PathVariable String email) {
		SignUpEntity user = signUpRepository.findByemail(email);
		if (user == null) {
			throw new RuntimeException("User not found");
		}
		SignUpResponse signUpResponse = new SignUpResponse();
		signUpResponse.setEmail(user.getEmail());
		signUpResponse.setPassword(user.getPassword());
		return signUpResponse;
	}
	
	

}

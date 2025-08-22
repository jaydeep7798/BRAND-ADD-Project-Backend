package com.brand.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brand.model.LoginModel;
import com.brand.model.response.LoginResponse;
import com.brand.security.JwtUtil;
import com.brand.service.LoginService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class LoginController {
	
	@Autowired
	private  LoginService loginService;
	
	@Autowired
    private JwtUtil jwtUtil;
	
	private final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginModel request) {
    	  logger.info("Login attempt for email: {}", request.getEmail());

          LoginResponse response = loginService.login(request);

          if (response.isSuccess()) {
              // Generate JWT token
              String token = jwtUtil.generateToken(request.getEmail());
              response.setToken(token);  // Add token to response
              logger.info("Login successful for email: {}", request.getEmail());
              return ResponseEntity.ok(response); // HTTP 200
          } else {
              logger.warn("Login failed for email: {}", request.getEmail());
              return ResponseEntity.status(401).body(response); // HTTP 401 Unauthorized
          }
    }
    
    @GetMapping("/msg")
    public String getMessage() {
    	return "Its Working";
    }
}

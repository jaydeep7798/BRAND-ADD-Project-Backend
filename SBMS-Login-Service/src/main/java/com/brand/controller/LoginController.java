package com.brand.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brand.model.LoginModel;
import com.brand.model.response.LoginResponse;
import com.brand.security.JwtUtil;
import com.brand.service.LoginService;



@RestController
@RequestMapping("/api")
public class LoginController {
	
	@Autowired
	private  LoginService loginService;
	
	@Autowired
    private JwtUtil jwtUtil;
	
	private final org.slf4j.Logger  logger = LoggerFactory.getLogger(LoginController.class);
	
	private String email ="";
	
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginModel request) {
    	  logger.info("Login attempt for email: {}", request.getEmail());
    	  email =request.getEmail();
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
     
    @PostMapping("/test")
    public ResponseEntity<?> addDetails(@RequestBody Map<String, Object> body,@RequestHeader Map<String, String> headers) {
    	logger.info("🔑 Authorization Header: " + headers.get("authorization"));
    	logger.info("Received body: " + body);
        return ResponseEntity.ok(body);
    }
    
    @GetMapping("/validate")
    public ResponseEntity<Boolean> validateToken(@RequestParam String token) {
        boolean valid = jwtUtil.validateToken(token);
        return ResponseEntity.ok(valid);
    }
}

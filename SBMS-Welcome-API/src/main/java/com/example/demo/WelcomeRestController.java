package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WelcomeRestController {
	@GetMapping("/welcome")
	public String WelcomeMsg() {
		return "welcome API is working , ";
	}

}

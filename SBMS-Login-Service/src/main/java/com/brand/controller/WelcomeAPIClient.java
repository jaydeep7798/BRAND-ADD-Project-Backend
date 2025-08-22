package com.brand.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="SBMS-Welcome-API")
public interface WelcomeAPIClient {
	@GetMapping("/welcome")
	public String invokeWelcomeAPI();

}

package com.brand.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "SBMS-LoginService")
public interface AuthInterface {
	@GetMapping("/api/validate")
    Boolean validateToken(@RequestParam("token") String token);

}

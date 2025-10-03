package com.brand.client;

import org.springframework.cloud.openfeign.FeignClient;
import com.brand.common.dto.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "SBMS-SignUp-Service")
public interface SignUpClient {
	  @GetMapping("/api/{email}")
	  SignUpResponse getUserByEmail(@PathVariable("email") String email);
}
 
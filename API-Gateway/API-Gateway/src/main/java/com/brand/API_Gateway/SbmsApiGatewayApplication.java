package com.brand.API_Gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com.brand")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.brand")
public class SbmsApiGatewayApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(SbmsApiGatewayApplication.class, args);
	}

}

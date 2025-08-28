package com.brand.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.brand.controller.AuthInterface;

import reactor.core.publisher.Mono;

@Service
public class JwtValidationService {

    private final WebClient webClient;

    public JwtValidationService(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://SBMS-LoginService").build();
    }

    public Mono<Boolean> isTokenValid(String token) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/api/validate")
                        .queryParam("token", token)
                        .build())
                .retrieve()
                .bodyToMono(Boolean.class)
                .onErrorReturn(false);
    }
}

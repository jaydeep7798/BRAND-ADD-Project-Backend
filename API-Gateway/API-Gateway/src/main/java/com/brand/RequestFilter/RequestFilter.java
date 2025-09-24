package com.brand.RequestFilter;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.brand.Service.JwtValidationService;


import reactor.core.publisher.Mono;

@Component
public class RequestFilter implements GlobalFilter, Ordered  {

    @Autowired
    private JwtValidationService jwtValidationService;
    
    private final Logger logger = LoggerFactory.getLogger(RequestFilter.class);

    @Override
    public int getOrder() {
        return -1; // run before other filters
    }
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String path = exchange.getRequest().getURI().getPath();
        HttpMethod method = exchange.getRequest().getMethod();
        logger.info("The Filter are Working");
        
        // Allow login API without token
        if (path.startsWith("/api/login") || path.startsWith("/api/signUp") ) {
            return chain.filter(exchange);
        }

        // Get Authorization header
        HttpHeaders headers = exchange.getRequest().getHeaders();
        String authHeader = headers.getFirst(HttpHeaders.AUTHORIZATION);

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        String token = authHeader.substring(7);

        // ✅ Call JwtValidationService in a NON-blocking way
        return jwtValidationService.isTokenValid(token)
                .flatMap(valid -> {
                    if (!valid) {
                        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                        return exchange.getResponse().setComplete();
                    }
                    return chain.filter(exchange);
                });
    }
}

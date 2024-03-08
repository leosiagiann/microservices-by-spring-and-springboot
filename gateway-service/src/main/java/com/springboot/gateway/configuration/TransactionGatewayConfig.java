package com.springboot.gateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Leonardo Siagian
 * Created on 08/03/2024
 */
@Configuration
public class TransactionGatewayConfig {
    @Bean
    public RouteLocator transactionLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("product-service", r -> r.path("/api/transactions/**")
                        .uri("lb://transaction-service"))
                .build();
    }
}

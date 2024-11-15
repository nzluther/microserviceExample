package com.spring.apigateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    private static final Logger logger = LoggerFactory.getLogger(GatewayConfig.class);

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {

        logger.info("Configuring API Gateway routes...");
        return builder.routes()
                // Route for api/greet
                .route("rest-api", r -> r.path("/api/**")
                        .uri("lb://simple-rest-api"))
               // Route for /gw/api/greet
                .route("rest-api-alt", r -> r.path("/gw/api/**")
                        .filters(f -> f.stripPrefix(1)) // Strips "/gw" from the path
                        .uri("lb://simple-rest-api"))
                .build();
    }
}


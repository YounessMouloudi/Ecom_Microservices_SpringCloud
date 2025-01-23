package com.projects.gatewayservice;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//public class GatewayConfig {
//
//    /* hadi aussi une configuration de gateway d'une maniere statique hit f statique tankono 3arfin
//    l'address (Uri) dial kol microservices mais en réalité on le connais pas, on le connais juste le nom
//    du microservice alors c'est pour ça en config d'une maniere dynamique a partir du discovery service
//    */
//
//    // had la methode ghir copietha mn 3and l Prof makhdamtch biha
//    @Bean
//    RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route(r -> r.path("/customers/**").uri("http://localhost:8081/"))
//                .route(r -> r.path("/products/**").uri("http://localhost:8082/"))
//                .build();
//    }
//}

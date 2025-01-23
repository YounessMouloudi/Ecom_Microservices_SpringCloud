package com.projects.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }


    /* hadi hia la maniere pour configurer gateway Dynamique; avant en rename le fichier application.yml pour
       éliminer la manier static
       pour acceder en fait http://localhost:8888/CUSTOMER-SERVICE/customers
       db wlina n9adro ndiro nom du microservice en miniscule comme ça http://localhost:8888/customer-service/customers
       hit en majuscule tatji S3iba chwia mais khass tzid wahd propertie f app.properties
    */
    @Bean
    DiscoveryClientRouteDefinitionLocator locator(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties dlp) {
        return new DiscoveryClientRouteDefinitionLocator(rdc,dlp);
    }

}

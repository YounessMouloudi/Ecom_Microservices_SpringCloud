package com.projects.inventoryservice.config;

import com.projects.inventoryservice.entities.Product;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RepositoryRestConfig implements RepositoryRestConfigurer {
    /* had l class drnah pour personnaliser la configuration de Spring Data Rest ay t afficher dakchi li bghiti
    nta hit par défaut matay affichiche lina les ids alors ghadi ngolo lih f la methode quand tu veux
    serialiser l'obj product en format JSON j'autorise d'exopser ou serialiser les ids aussi */
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Product.class);
    }
}

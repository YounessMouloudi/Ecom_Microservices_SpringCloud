package com.projects.inventoryservice;

import com.projects.inventoryservice.entities.Product;
import com.projects.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            productRepository.save(Product.builder()
                            .id(UUID.randomUUID().toString()).name("Computer")
                            .price(3500.00).quantity(15)
                            .build());
            productRepository.save(Product.builder()
                            .id(UUID.randomUUID().toString()).name("SmartPhone")
                            .price(2500.00).quantity(25)
                            .build());
            productRepository.save(Product.builder()
                            .id(UUID.randomUUID().toString()).name("Tablet")
                            .price(1500.00).quantity(10)
                            .build());
//            productRepository.save(new Product(UUID.randomUUID().toString(),"Laptop", 1500.00, 10));
//            productRepository.save(new Product(UUID.randomUUID().toString(),"Smartphone", 800.00, 20));
//            productRepository.save(new Product(UUID.randomUUID().toString(),"Tablet", 500.00, 15));

            productRepository.findAll().forEach(p -> {
                System.out.println("=======================");
                System.out.println("ID: " + p.getId());
                System.out.println("Name: " + p.getName());
                System.out.println("Price: " + p.getPrice());
                System.out.println("Quantity: " + p.getQuantity());
                System.out.println("=======================");
            });
        };
    }

}

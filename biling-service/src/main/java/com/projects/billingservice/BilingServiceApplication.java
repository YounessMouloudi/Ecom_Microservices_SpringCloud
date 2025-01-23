package com.projects.billingservice;

import com.projects.billingservice.entities.Bill;
import com.projects.billingservice.entities.ProductItem;
import com.projects.billingservice.feignRest.CustomerRestClient;
import com.projects.billingservice.feignRest.ProductRestClient;
import com.projects.billingservice.models.Customer;
import com.projects.billingservice.models.Product;
import com.projects.billingservice.repositories.BillRepository;
import com.projects.billingservice.repositories.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BilingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BilingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BillRepository billRepository,
                                        ProductItemRepository productItemRepository,
                                        CustomerRestClient customerRestClient,
                                        ProductRestClient productRestClient) {

        return args -> {
            Collection<Customer> customers = customerRestClient.getAllCustomers().getContent();
            Collection<Product> products = productRestClient.getAllProducts().getContent();

            customers.forEach(customer -> {
                Bill bill = Bill.builder()
                        .billingDate(new Date())
                        .customerId(customer.getId())
                        .build();

                billRepository.save(bill);

                products.forEach(product -> {
                    ProductItem productItem = ProductItem.builder()
                            .bill(bill)
                            .productId(product.getId())
                            .quantity(1 + new Random().nextInt(10))
                            .unitPrice(product.getPrice())
                            .build();

                    productItemRepository.save(productItem);
                });
            });
        };
    }

}

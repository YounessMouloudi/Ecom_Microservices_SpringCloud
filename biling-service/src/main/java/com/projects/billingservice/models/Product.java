package com.projects.billingservice.models;

import lombok.*;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;
}

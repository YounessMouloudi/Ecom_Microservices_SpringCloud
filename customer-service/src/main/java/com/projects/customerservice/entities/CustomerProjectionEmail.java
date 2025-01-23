package com.projects.customerservice.entities;

import org.springframework.data.rest.core.config.Projection;

// http://localhost:8081/customers?projection=email
// http://localhost:8081/customers/1?projection=email
@Projection(name = "email", types = Customer.class)
public interface CustomerProjectionEmail {
    String getEmail();
}

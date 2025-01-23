package com.projects.billingservice.feignRest;

import com.projects.billingservice.models.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
/* hna on fait just le nom du microservice et openFeign va contacter discovery pour récupurer son adress
et aprés il va retourner les donnees de customer en json mais khass ykono les attributs de Customer de
models 3ndhom nafss smia dial Customer de customer-service */
public interface CustomerRestClient {

    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customerServiceCB",fallbackMethod = "getDefaultCustomer")
    Customer getCustomerById(@PathVariable Long id);

    @GetMapping("/customers")
    @CircuitBreaker(name = "customerServiceCB",fallbackMethod = "getDefaultCustomers")
    PagedModel<Customer> getAllCustomers();

    default Customer getDefaultCustomer(Long id,Exception exception) {
        return Customer.builder().id(id).name("Default Name").email("Default Email")
                .build();
    }
    default PagedModel<Customer> getDefaultCustomers(Exception exception) {
        return PagedModel.empty();
    }
}

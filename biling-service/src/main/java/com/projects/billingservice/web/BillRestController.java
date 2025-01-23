package com.projects.billingservice.web;

import com.projects.billingservice.entities.Bill;
import com.projects.billingservice.feignRest.CustomerRestClient;
import com.projects.billingservice.feignRest.ProductRestClient;
import com.projects.billingservice.repositories.BillRepository;
import com.projects.billingservice.repositories.ProductItemRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController {

    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;

    private CustomerRestClient customerRestClient;
    private ProductRestClient productRestClient;


    public BillRestController(BillRepository billRepository, ProductItemRepository productItemRepository,
                              CustomerRestClient customerRestClient, ProductRestClient productRestClient) {
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
        this.customerRestClient = customerRestClient;
        this.productRestClient = productRestClient;
    }

    @GetMapping("/bills/{id}")
    public Bill getBill(@PathVariable Long id) {
        Bill bill = billRepository.findById(id).get();
        bill.setCustomer(customerRestClient.getCustomerById(bill.getCustomerId()));
        bill.getProductItems().forEach(productItem -> {
            productItem.setProduct(productRestClient.getProductById(productItem.getProductId()));
        });
        return bill;
    }
}

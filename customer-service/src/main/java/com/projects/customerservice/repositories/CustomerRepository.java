package com.projects.customerservice.repositories;

import com.projects.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
/* had l'annotation il est fournit par Spring Data Rest il demande a spring de demarer un web service
Restfull qui permet d'acceder e tous les methodes (CRUD) de cette interface CustomerRepository */
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}

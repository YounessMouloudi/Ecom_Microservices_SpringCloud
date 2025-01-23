package com.projects.customerservice.entities;

import org.springframework.data.rest.core.config.Projection;

/* had les projections tan personnalisiw bihom l'affichage dial les données ay 9rib chwia l GraphQL homa
   madyourin ghir pour lire les données çad getters, c'est pas pour setters, ça il existe dans Data Rest
   => par ex : 3ndi Customer fih bzf d les données mais ana bghit wahd l'affichage ykon fih ghir name et email
   alors hna ghadi nsta3mlo had projection bhad tari9a bsti3mal l'annotation @Projection
   f name="all" n9adro ndiro ayi smia et pour acceder a ce projection tandiro :
   http://localhost:8081/customers?projection=all
   http://localhost:8081/customers/1?projection=all
*/
@Projection(name = "all", types = Customer.class)
public interface CustomerProjection {
    String getName();
    String getEmail();
}

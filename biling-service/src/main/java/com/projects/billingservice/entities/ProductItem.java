package com.projects.billingservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.projects.billingservice.models.Product;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder
public class ProductItem {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productId;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Bill bill;
    private int quantity;
    private double unitPrice;

    /* hna had l'annotaion il existe dans JPA drnaha bach ngolo l JPA t ignori had l'attribut dial had class
    ay ana had l class kayn ghi f les models mais makaynch f BD ay càd n'est pas entity hit par déf JPA
    tatgolina bila had l class khasso ykon entity mais hna mamhtajinoch ykon f bd bghinah ghir hna w hit déja
    3ndna f BD de customer-service */
    @Transient
    private Product product;
}

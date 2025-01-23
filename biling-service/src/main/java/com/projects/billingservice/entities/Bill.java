package com.projects.billingservice.entities;

import com.projects.billingservice.models.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder
public class Bill {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Date billingDate;
    /* hna had customerId ghaykon howa la relation mabin Customer w Billing hit class Customer machi entity
    alors man9adroch ndiro l'annotation de relation */
    private Long customerId;
    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItems = new ArrayList<>();

    /* hna had l'annotaion il existe dans JPA drnaha bach ngolo l JPA t ignori had l'attribut dial had class
    ay ana had l class kayn ghi f les models mais makaynch f BD ay càd n'est pas entity hit par déf JPA
    tatgolina bila had l class khasso ykon entity mais hna mamhtajinoch ykon f bd bghinah ghir hna w hit déja
    3ndna f BD de customer-service */
    @Transient
    private Customer customer;
}

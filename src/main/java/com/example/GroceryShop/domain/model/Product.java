package com.example.GroceryShop.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private String productDescription;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Review> productReviews;
    private float basePrice;
    private float percentOfTaxes;
    private LocalDate dateOfAddition;
    private LocalDate dateOfExpiry;
    private int interestedInCounter;
    private boolean isAvaiable;


    public Product(String productName, String productDescription, float basePrice, float percentOfTaxes){
        this.productName = productName;
        this.productDescription = productDescription;
        this.basePrice = basePrice;
        this.percentOfTaxes = percentOfTaxes;
    }

}

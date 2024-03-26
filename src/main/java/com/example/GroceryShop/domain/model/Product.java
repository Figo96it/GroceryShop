package com.example.GroceryShop.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private String productDescription;
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

    public void setBasePrice(float basePrice) {
        this.basePrice = basePrice;
    }
}

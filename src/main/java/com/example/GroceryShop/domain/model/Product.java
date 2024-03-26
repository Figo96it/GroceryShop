package com.example.GroceryShop.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private String productDescription;
    private List<Review> prouctReviews;
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

package com.example.GroceryShop.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameProduct;
    private BigDecimal price;
    private ProductCategoryEnum productCategoryEnum;

    public Product(String nameProduct, BigDecimal price, ProductCategoryEnum productCategoryEnum) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.productCategoryEnum = productCategoryEnum;
    }
}

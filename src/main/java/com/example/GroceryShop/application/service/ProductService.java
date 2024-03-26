package com.example.GroceryShop.application.service;

import com.example.GroceryShop.domain.model.Product;

import java.time.LocalDate;

public interface ProductService {
    Product addProduct(String productName, String productDescription, float basePrice, float percentOfTaxe);
    Product getProductById(Long id);
}

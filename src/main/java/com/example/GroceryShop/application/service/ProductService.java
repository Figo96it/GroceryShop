package com.example.GroceryShop.application.service;

import com.example.GroceryShop.domain.model.Product;
import com.example.GroceryShop.domain.model.Product;

import java.time.LocalDate;
import java.util.List;

public interface ProductService {
    Product addProduct(String productName, String productDescription, float basePrice, float percentOfTaxe);
    Product getProductById(Long id);
    void deleteProduct(Long id);
    List<Product> listProducts();
    void changeProductPrice(Long id, float newBasePrice);
}

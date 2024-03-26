package com.example.GroceryShop.application.service;

import com.example.GroceryShop.domain.model.Client;
import com.example.GroceryShop.domain.model.Product;
import com.example.GroceryShop.infrastructure.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private List<Client> clientList;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product addProduct(String productName, String productDescription, float basePrice, float percentOfTaxe) {
        //Create new product
        Product product = new Product(productName, productDescription, basePrice, percentOfTaxe);
        //Save to dataBase
        return productRepository.save(product);

    }

    @Override
    public Product getProductById(Long id) {
        //Find user by id from repository
        return productRepository.findById(id).orElse(null);
    }
}

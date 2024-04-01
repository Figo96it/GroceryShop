package com.example.GroceryShop.application.service;

import com.example.GroceryShop.domain.model.Product;
import com.example.GroceryShop.domain.model.ProductCategoryEnum;
import com.example.GroceryShop.infrastructure.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImplByGrzegorz {
    private final ProductRepository productRepository;

    public ProductServiceImplByGrzegorz(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Product createProduct(String nameProduct, BigDecimal price, ProductCategoryEnum productCategoryEnum){
        Product productGrzegorz = new Product(nameProduct, price, productCategoryEnum);
        this.productRepository.save(productGrzegorz);
        return productGrzegorz;
    }
    public void deleteProduct(Long id){
        Optional<Product> optionalProduct =  productRepository.findById(id);
        if (optionalProduct.isPresent()){productRepository.deleteById(id);}
        else {
            throw new EntityNotFoundException("Brakuje id w bazie danych");
        }
    }

    public Product getProductById(Long id){
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> listProduct(){
       return productRepository.findAll();

    }

}

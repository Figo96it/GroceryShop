package com.example.GroceryShop.infrastructure.repository;

import com.example.GroceryShop.domain.model.Product;
import io.micrometer.common.lang.NonNullApi;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@NonNullApi
public interface ProductRepository extends JpaRepository<Product, Long> {

  Optional<Product> findById(Long id);
}

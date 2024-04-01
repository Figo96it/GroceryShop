package com.example.GroceryShop.infrastructure.repository;

import com.example.GroceryShop.domain.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Long> {}

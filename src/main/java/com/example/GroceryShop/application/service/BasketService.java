package com.example.GroceryShop.application.service;

import com.example.GroceryShop.domain.model.Basket;
import com.example.GroceryShop.domain.model.Client;
import com.example.GroceryShop.domain.model.Product;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface BasketService {
  Basket createBasket(Client client, LocalDate creationDate, boolean active);

  void addProductToBasket(Basket basket, Product product);

  void removeProductFromBasket(Basket basket, Product product);

  List<Product> getProducts(Basket basket);

  BigDecimal calculateTotalAmount(Basket basket);
}

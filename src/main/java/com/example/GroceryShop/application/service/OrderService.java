package com.example.GroceryShop.application.service;

import com.example.GroceryShop.domain.model.Order;
import com.example.GroceryShop.domain.model.Product;
import java.util.List;

public interface OrderService {
  List<Order> addProduct(Product product);

  void removeProduct(Long id);

  List<Order> getProducts();

  Double calculateTotalAmount();
}

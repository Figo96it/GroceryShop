package com.example.GroceryShop.application.service;

import com.example.GroceryShop.domain.model.Basket;
import com.example.GroceryShop.domain.model.Client;
import com.example.GroceryShop.domain.model.Order;
import com.example.GroceryShop.domain.model.Product;
<<<<<<< HEAD

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {
    Order createOrderFromBasket(Client client, Basket basket);

    void removeOrder(Long id);

    List<Order> listOrder();

    BigDecimal calculateTotalAmountFromBasket(Order order);
=======
import java.util.List;

public interface OrderService {
  List<Order> addProduct(Product product);

  void removeProduct(Long id);
>>>>>>> 736841352b8597d2cd75faf7db89101609783b87

  List<Order> getProducts();

  Double calculateTotalAmount();
}

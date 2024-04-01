package com.example.GroceryShop.application.service;

import com.example.GroceryShop.domain.model.Basket;
import com.example.GroceryShop.domain.model.Client;
import com.example.GroceryShop.domain.model.Order;
import com.example.GroceryShop.domain.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {
    Order createOrderFromBasket(Client client, Basket basket);

    void removeOrder(Long id);

    List<Order> listOrder();

    BigDecimal calculateTotalAmountFromBasket(Order order);


}

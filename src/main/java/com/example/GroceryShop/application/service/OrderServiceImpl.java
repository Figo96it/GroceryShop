package com.example.GroceryShop.application.service;

import com.example.GroceryShop.domain.model.Order;
import com.example.GroceryShop.domain.model.Product;

import com.example.GroceryShop.infrastructure.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
  private final OrderRepository orderRepository;

  public OrderServiceImpl(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @Override
  public List<Order> addProduct(Product product) {
    return null;
  }

  @Override
  public void removeProduct(Long id) {
    orderRepository.deleteById(id);
  }

  @Override
  public List<Order> getProducts() {
    return orderRepository.findAll();
  }

  @Override
  public Double calculateTotalAmount() {
    return null;
  }
}

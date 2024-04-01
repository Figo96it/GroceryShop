package com.example.GroceryShop.application.service;

import com.example.GroceryShop.domain.model.Basket;
import com.example.GroceryShop.domain.model.Client;
import com.example.GroceryShop.domain.model.Order;

import com.example.GroceryShop.domain.model.Product;
import com.example.GroceryShop.infrastructure.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

<<<<<<< HEAD
import static org.springframework.boot.web.server.Ssl.ClientAuth.map;

=======
>>>>>>> 736841352b8597d2cd75faf7db89101609783b87
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

<<<<<<< HEAD
    @Override
    public Order createOrderFromBasket(Client client, Basket basket) {
        Order order = new Order();
        order.setClient(client);
        order.setBasket(basket);
        return orderRepository.save(order);
    }

    @Override
    public void removeOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<Order> listOrder() {
        return orderRepository.findAll();
    }

    @Override
    public BigDecimal calculateTotalAmountFromBasket(Order order) {
        BigDecimal totalAmount = BigDecimal.ZERO;
        List<Product> baskets = order.getBasket().getProductList();
        for (Product product : baskets) {
            totalAmount = totalAmount.add(product.getPrice());
        }
        return totalAmount;
    }
=======
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
>>>>>>> 736841352b8597d2cd75faf7db89101609783b87
}

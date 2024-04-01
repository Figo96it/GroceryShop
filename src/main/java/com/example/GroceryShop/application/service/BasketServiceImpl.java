package com.example.GroceryShop.application.service;

import com.example.GroceryShop.domain.model.Basket;
import com.example.GroceryShop.domain.model.Client;
import com.example.GroceryShop.domain.model.Product;
import com.example.GroceryShop.infrastructure.repository.BasketRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class BasketServiceImpl implements BasketService {
  private final BasketRepository basketRepository;

  //  List<Product> productList = new ArrayList<>();
  @Autowired
  public BasketServiceImpl(BasketRepository basketRepository) {
    this.basketRepository = basketRepository;
  }

  @Override
  public Basket createBasket(Client client, LocalDate creationDate, boolean active) {
    Basket basket = new Basket(client, creationDate, active);
    return basketRepository.save(basket);
  }

  @Override
  public void addProductToBasket(Basket basket, Product product) {
    basket.addProduct(product);
  }

  @Override
  public void removeProductFromBasket(Basket basket, Product product) {
    basket.removeProduct(product);
  }

  @Override
  public List<Product> getProducts(Basket basket) {
    return basket.listProductFromBasket();
  }

<<<<<<< HEAD
    @Override
    public List<Product> getProducts(Basket basket) {
        return basket.listProductFromBasket();
    }
    @Override
    public BigDecimal calculateTotalAmount(Basket basket) {

        return basket.listProductFromBasket()
                .stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }
=======
  @Override
  public BigDecimal calculateTotalAmount(Basket basket) {
>>>>>>> 736841352b8597d2cd75faf7db89101609783b87

    return basket.listProductFromBasket().stream()
        .map(Product::getPrice)
        .reduce(BigDecimal.ZERO, BigDecimal::add);
  }
}

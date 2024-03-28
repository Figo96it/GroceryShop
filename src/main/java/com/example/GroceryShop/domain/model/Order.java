package com.example.GroceryShop.domain.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne
  @JoinColumn(name = "basket_id")
  private Basket basket;

  private List<Product> products;

  @OneToMany
  @JoinColumn(name = "client_id")
  private Client client;

  private LocalDate orderDate;
  private String shippingAddress;
  private Double totalAmount;

  public Basket getBasket() {
    return basket;
  }

  public void setBasket(Basket basket) {
    this.basket = basket;
  }
}

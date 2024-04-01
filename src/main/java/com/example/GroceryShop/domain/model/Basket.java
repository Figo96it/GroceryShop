package com.example.GroceryShop.domain.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Basket {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne
  @JoinColumn(name = "client_id")
  private Client client;

  private LocalDate creationDate;
  private boolean active;
  private List<Product> productList;

  public Basket(Client client, LocalDate creationDate, boolean active) {
    this.client = client;
    this.creationDate = creationDate;
    this.active = active;
    this.productList = new ArrayList<>();
  }

  public Client getClient() {
    return client;
  }

<<<<<<< HEAD
    public void addProduct(Product product) {
        this.active = true;
        this.productList.add(product);
    }

    public void removeProduct(Product product) {

        this.productList.remove(product);
        if (productList.size() == 0) this.active = false;
    }

    public void clearBasket() {
        this.active = false;
        this.productList.clear();
    }

    public List<Product> listProductFromBasket() {
        return this.productList;
    }
=======
  public void setClient(Client client) {
    this.client = client;
  }

  public void addProduct(Product product) {
    this.active = true;
    this.productList.add(product);
  }

  public void removeProduct(Product product) {

    this.productList.remove(product);
    if (productList.size() == 0) this.active = false;
  }

  public void clearBasket() {
    this.active = false;
    this.productList.clear();
  }

  public List<Product> listProductFromBasket() {
    return this.productList;
  }
>>>>>>> 736841352b8597d2cd75faf7db89101609783b87
}

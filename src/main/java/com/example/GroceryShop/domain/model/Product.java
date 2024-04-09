package com.example.GroceryShop.domain.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String productName;
  private String productDescription;

  @OneToMany(mappedBy = "product")
  private List<Price> prices;

  private float percentOfTax;

  @ManyToOne
  @JoinColumn(name = "category_id")
  private ProductCategory productCategory;

  @ManyToOne
  @JoinColumn(name = "group_id")
  private ProductGroup productGroup;

  public Product(
      String productName,
      String productDescription,
      List<Price> prices,
      float percentOfTaxe,
      ProductCategory productCategory,
      ProductGroup productGroup) {
    this.productName = productName;
    this.productDescription = productDescription;
    this.prices = prices;
    this.percentOfTax = percentOfTaxe;
    this.productCategory = productCategory;
    this.productGroup = productGroup;
  }
}

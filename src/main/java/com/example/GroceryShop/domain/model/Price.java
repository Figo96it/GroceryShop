package com.example.GroceryShop.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "prices")
public class Price {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "price_value", nullable = false, precision = 38, scale = 2)
  private BigDecimal value;

  @Column(nullable = false)
  private String currency;

  @Column(name = "effective_date", nullable = false)
  private LocalDateTime effectiveDate;

  @ManyToOne
  @JoinColumn(name = "product_id", nullable = false)
  private Product product;
}

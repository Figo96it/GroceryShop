package com.example.GroceryShop.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Support {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
}

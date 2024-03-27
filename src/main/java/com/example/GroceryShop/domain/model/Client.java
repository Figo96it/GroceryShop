package com.example.GroceryShop.domain.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clients")
public class Client {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String username;
  private String password;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "client_roles",
      joinColumns = @JoinColumn(name = "client_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

  private boolean enabled;
  private String surName;
  private LocalDate dateOfRegistration;
  private LocalDate dateOfBorn;
  private String email;

  public Client(
      String name,
      String username,
      LocalDate dateOfRegistration,
      LocalDate dateOfBorn,
      String email) {
    this.name = name;
    this.username = username;
    this.dateOfRegistration = dateOfRegistration;
    this.dateOfBorn = dateOfBorn;
    this.email = email;
  }
}

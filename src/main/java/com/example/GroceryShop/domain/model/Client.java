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
  @Column(unique = true, nullable = false)
  private Long id;

  private String firstName;
  private String userName;
  private String password;

  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
  @JoinTable(
      name = "client_roles",
      joinColumns = @JoinColumn(name = "client_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

  private boolean enabled;
  private String lastName;
  private LocalDate dateOfRegistration;
  private LocalDate dateOfBorn;
  private String email;

  public Client(
      String firstName,
      String userName,
      LocalDate dateOfRegistration,
      LocalDate dateOfBorn,
      String email) {
    this.firstName = firstName;
    this.userName = userName;
    this.dateOfRegistration = dateOfRegistration;
    this.dateOfBorn = dateOfBorn;
    this.email = email;
  }

  public Client(String userName, String email, String password) {
    this.userName = userName;
    this.email = email;
    this.password = password;
  }

  public Client(String firstName, String userName, String password, String lastName, String email) {
    this.firstName = firstName;
    this.userName = userName;
    this.password = password;
    this.lastName = lastName;
    this.email = email;
  }
}

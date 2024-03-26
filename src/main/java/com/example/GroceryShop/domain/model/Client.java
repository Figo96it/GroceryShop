package com.example.GroceryShop.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@Table(name = "clients")
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String clientName;
    private String password;
    private String surName;
    @Column(name = "date_of_registration")
    private LocalDate dateOfRegistration;
    private LocalDate dateOfBorn;
    private String email;

    public Client(String name, String clientName, LocalDate dateOfRegistration, LocalDate dateOfBorn, String email) {
        this.name = name;
        this.clientName = clientName;
        this.dateOfRegistration = dateOfRegistration;
        this.dateOfBorn = dateOfBorn;
        this.email = email;
    }

}

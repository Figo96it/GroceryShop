package com.example.GroceryShop.domain.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private  String clientName;
    private String surName;
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
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public LocalDate getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(LocalDate dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public LocalDate getDateOfBorn() {
        return dateOfBorn;
    }

    public void setDateOfBorn(LocalDate dateOfBorn) {
        this.dateOfBorn = dateOfBorn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surName + '\'' +
                ", dateOfRegistration=" + dateOfRegistration +
                ", dateOfBorn=" + dateOfBorn +
                '}';
    }



}

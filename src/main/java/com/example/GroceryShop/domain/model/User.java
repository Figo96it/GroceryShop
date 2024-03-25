package com.example.GroceryShop.domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {
    private Long id;
    private String name;
    private  String userName;
    private String surname;
    private LocalDate dateOfRegistration;
    private LocalDate dateOfBorn;
    private String email;


    public User() {

    }



    public User(Long id, String name, String userName, LocalDate dateOfRegistration, LocalDate dateOfBorn, String email) {

        this.id = id;
        this.name = name;
        this.userName = userName;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfRegistration=" + dateOfRegistration +
                ", dateOfBorn=" + dateOfBorn +
                '}';
    }



}

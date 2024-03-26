package com.example.GroceryShop.application.service;

import com.example.GroceryShop.domain.model.Client;

import java.time.LocalDate;

public interface ClientService {

    Client createUser(String name, String userName, LocalDate dateOfRegistration, LocalDate dateOfBorn, String email);
    Client getUserById(Long id);
}

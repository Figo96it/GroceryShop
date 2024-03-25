package com.example.GroceryShop.application.service;

import com.example.GroceryShop.domain.model.User;

import java.time.LocalDate;

public interface UserService {

    User createUser(String name, String userName, LocalDate dateOfRegistration, LocalDate dateOfBorn, String email);
    User getUserById(Long id);
}

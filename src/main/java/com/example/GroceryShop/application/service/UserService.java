package com.example.GroceryShop.application.service;

import com.example.GroceryShop.domain.model.User;

public interface UserService {

    User createUser(String userName, String email);
    User getUserById(Long id);
}

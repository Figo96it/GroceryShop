package com.example.GroceryShop.application.service;

import com.example.GroceryShop.domain.model.User;
import com.example.GroceryShop.infrastructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(String userName, String email) {
        //Create new user
        return null;
    }

    @Override
    public User getUserById(Long id) {
        //Find user by id from repo
        return null;
    }
}

package com.example.GroceryShop.application.service;

import com.example.GroceryShop.domain.model.User;
import com.example.GroceryShop.infrastructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private List<User> userList;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(String name, String userName, LocalDate dateOfRegistration, LocalDate dateOfBorn, String email) {
        User user = new User(null, name, userName,  dateOfRegistration,  dateOfBorn,  email);


        //Create new user
        return userList.add(user) ? user: null;

    }

    @Override
    public User getUserById(Long id) {

        //Find user by id from repo
        return null;
    }
}

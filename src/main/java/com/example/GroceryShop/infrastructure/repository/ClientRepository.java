package com.example.GroceryShop.infrastructure.repository;

import com.example.GroceryShop.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    //Create special queries
    List<Client> findByAgeGreaterThan(int age);

    Client findByUsername(String userName);
}

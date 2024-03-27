package com.example.GroceryShop.infrastructure.repository;

import com.example.GroceryShop.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    //Create special queries
    Client findByUsername(String username);

}

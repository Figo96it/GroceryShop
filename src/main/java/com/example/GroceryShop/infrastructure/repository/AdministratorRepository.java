package com.example.GroceryShop.infrastructure.repository;

import com.example.GroceryShop.domain.model.Administrator;
import com.example.GroceryShop.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {

    Optional<Administrator> findById(String id);

    Optional<Administrator> findUserByUsername(String username);

    List<Administrator> findBySurname(String surname);

    List<Administrator> findByName(String name);
}

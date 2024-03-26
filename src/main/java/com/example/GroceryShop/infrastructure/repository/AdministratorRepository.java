package com.example.GroceryShop.infrastructure.repository;

import com.example.GroceryShop.domain.model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {

    Optional<Administrator> findById(Long id);

}

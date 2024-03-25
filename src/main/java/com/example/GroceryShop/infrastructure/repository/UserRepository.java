package com.example.GroceryShop.infrastructure.repository;

import com.example.GroceryShop.domain.model.User;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(String id);

    Optional<User> findUserByUsername(String username);

    List<User> findBySurname(String surname);

    List<User> findByName(String name);
}

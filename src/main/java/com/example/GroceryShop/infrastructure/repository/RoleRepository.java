package com.example.GroceryShop.infrastructure.repository;

import com.example.GroceryShop.domain.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}

package com.example.GroceryShop.infrastructure.repository;

import com.example.GroceryShop.domain.model.ClientRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<ClientRole, Long> {
}

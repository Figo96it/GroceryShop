package com.example.GroceryShop.infrastructure.repository;

import com.example.GroceryShop.domain.model.ClientRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRoleRepository extends JpaRepository<ClientRole, Long> {}

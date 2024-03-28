package com.example.GroceryShop.infrastructure.init;

import com.example.GroceryShop.domain.model.Role;
import com.example.GroceryShop.infrastructure.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

  private final RoleRepository roleRepository;

  @Autowired
  public DataInitializer(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  @PostConstruct
  public void initializeData() {
    Role roleAdmin = new Role();
    roleAdmin.setName("ROLE_ADMIN");
    roleRepository.save(roleAdmin);

    Role roleUser = new Role();
    roleUser.setName("ROLE_USER");
    roleRepository.save(roleUser);
  }
}

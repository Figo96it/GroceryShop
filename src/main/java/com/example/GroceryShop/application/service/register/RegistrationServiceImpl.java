package com.example.GroceryShop.application.service.register;

import com.example.GroceryShop.domain.model.Client;
import com.example.GroceryShop.domain.model.Role;
import com.example.GroceryShop.infrastructure.repository.ClientRepository;
import com.example.GroceryShop.infrastructure.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {
  private final ClientRepository clientRepository;

  private RoleRepository roleRepository;

  @Autowired
  public RegistrationServiceImpl(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  @Override
  public void registerNewClient(Client client) {
    // Set default value for new user
    Role role = roleRepository.findByName("ROLE_USER");
    client.getRoles().add(role);
    client.setEnabled(true); // It can be set to false and activated after email confirmation
    clientRepository.save(client);
  }
}

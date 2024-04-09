package com.example.GroceryShop.application.service;

import com.example.GroceryShop.domain.model.Client;
import com.example.GroceryShop.infrastructure.repository.ClientRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

  private final ClientRepository clientRepository;

  public ClientServiceImpl(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  @Override
  public Client findByUserName(String userName) {
    return clientRepository.findByUserName(userName);
  }

  @Override
  public Client registerClient(Client client) {
    // Create new user
    return clientRepository.save(client);
  }

  @Override
  public Client getClientById(Long id) {
    // Find user by id from repository
    return clientRepository.findById(id).orElse(null);
  }

  @Override
  public void deleteClient(Long id) {
    // Delete user by id from repository
    clientRepository.deleteById(id);
  }

  @Override
  public List<Client> listClients() {
    return clientRepository.findAll();
  }
}

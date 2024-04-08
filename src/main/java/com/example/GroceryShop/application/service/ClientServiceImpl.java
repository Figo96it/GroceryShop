package com.example.GroceryShop.application.service;

import com.example.GroceryShop.domain.model.Client;
import com.example.GroceryShop.infrastructure.repository.ClientRepository;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
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
  public Client findByUsername(String username) {
    return clientRepository.findByUsername(username);
  }

  @Override
  public Client createClient(
      String name,
      String userName,
      LocalDate dateOfRegistration,
      LocalDate dateOfBorn,
      String email) {
    // Create new user
    Client client = new Client(name, userName, dateOfRegistration, dateOfBorn, email);
    // Save to dataBase
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

  @Override
  public void createClient(Client testClient) {
    clientRepository.save(testClient);
  }
}

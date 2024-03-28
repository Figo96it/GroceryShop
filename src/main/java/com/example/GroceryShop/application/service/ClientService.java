package com.example.GroceryShop.application.service;

import com.example.GroceryShop.domain.model.Client;
import java.time.LocalDate;
import java.util.List;

public interface ClientService {

  Client findByUsername(String username);

  Client createClient(
      String name,
      String userName,
      LocalDate dateOfRegistration,
      LocalDate dateOfBorn,
      String email);

  Client getClientById(Long id);

  void deleteClient(Long id);

  List<Client> listClients();

  void createClient(Client testClient);
}

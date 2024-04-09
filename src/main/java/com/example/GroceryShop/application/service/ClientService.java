package com.example.GroceryShop.application.service;

import com.example.GroceryShop.domain.model.Client;
import java.util.List;

public interface ClientService {

  Client findByUserName(String userName);

  Client registerClient(Client client);

  Client getClientById(Long id);

  void deleteClient(Long id);

  List<Client> listClients();
}

package com.example.GroceryShop.application.service;

import com.example.GroceryShop.domain.model.Client;
import com.example.GroceryShop.infrastructure.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    private List<Client> clientList;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client createUser(String name, String userName, LocalDate dateOfRegistration, LocalDate dateOfBorn, String email) {
        //Create new user
        Client client = new Client(name, userName, dateOfRegistration, dateOfBorn, email);
        //Save to dataBase
        return clientRepository.save(client);

    }

    @Override
    public Client getUserById(Long id) {
        //Find user by id from repository
        return clientRepository.findById(id).orElse(null);
    }
}

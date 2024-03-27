package com.example.GroceryShop.application.service;

import com.example.GroceryShop.domain.model.Client;
import com.example.GroceryShop.domain.model.Role;
import com.example.GroceryShop.infrastructure.repository.ClientRepository;
import com.example.GroceryShop.infrastructure.repository.RoleRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;

import java.time.LocalDate;
import java.util.List;


@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    private RoleRepository roleRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client register(Client client) {
        //Set default value for new user
        Role role = roleRepository.findByName("ROLE_USER");
        client.getRoles().add(role);
        //Encrypting the password before storing it in the database
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        client.setEnabled(true); //It can be set to false and activated after email confirmation
        return clientRepository.save(client);
    }

    @Override
    public Client findByUsername(String username) {
        return clientRepository.findByUsername(username);
    }

    @Override
    public Client createClient(String name, String userName, LocalDate dateOfRegistration, LocalDate dateOfBorn, String email) {
        //Create new user
        Client client = new Client(name, userName, dateOfRegistration, dateOfBorn, email);
        //Save to dataBase
        return clientRepository.save(client);

    }

    @Override
    public Client getClientById(Long id) {

        //Find user by id from repository
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteClient(Long id) {
        //Delete user by id from repository
        clientRepository.deleteById(id);
    }

    @Override
    public List<Client> listClients() {
        return clientRepository.findAll();
    }

}

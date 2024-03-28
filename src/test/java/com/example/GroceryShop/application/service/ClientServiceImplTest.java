package com.example.GroceryShop.application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.example.GroceryShop.domain.model.Client;
import com.example.GroceryShop.infrastructure.repository.ClientRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ClientServiceImplTest {

    private ClientServiceImpl clientService;

    @Mock
    private ClientRepository clientRepository;

    @BeforeEach
    public void setUp() {
        clientService = new ClientServiceImpl(clientRepository);
    }

    @Test
    public void testFindByUsername() {
        String username = "testUser";
        Client client = new Client("Test Name", username, LocalDate.now(), LocalDate.now(), "test@example.com");

        when(clientRepository.findByUsername(username)).thenReturn(client);

        Client result = clientService.findByUsername(username);

        assertEquals(client, result);
    }

    @Test
    public void testCreateClient() {
        Client client = new Client("Test Name", "testUser", LocalDate.now(), LocalDate.now(), "test@example.com");

        when(clientRepository.save(client)).thenReturn(client);

        Client result = clientService.createClient("Test Name", "testUser", LocalDate.now(), LocalDate.now(), "test@example.com");

        assertEquals(client, result);
    }

    @Test
    public void testGetClientById() {
        Long id = 1L;
        Client client = new Client("Test Name", "testUser", LocalDate.now(), LocalDate.now(), "test@example.com");

        when(clientRepository.findById(id)).thenReturn(Optional.of(client));

        Client result = clientService.getClientById(id);

        assertEquals(client, result);
    }

    @Test
    public void testDeleteClient() {
        Long id = 1L;

        clientService.deleteClient(id);

        verify(clientRepository, times(1)).deleteById(id);
    }

    @Test
    public void testListClients() {
        List<Client> clients = new ArrayList<>();
        clients.add(new Client("Test Name", "testUser", LocalDate.now(), LocalDate.now(), "test@example.com"));

        when(clientRepository.findAll()).thenReturn(clients);

        List<Client> result = clientService.listClients();

        assertEquals(clients, result);
    }
}

package com.example.GroceryShop.application.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.example.GroceryShop.application.service.register.RegistrationService;
import com.example.GroceryShop.domain.model.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RegistrationControllerTest {

  private RegistrationController registrationController;

  @Mock private RegistrationService registrationService;

  @BeforeEach
  void setUp() {
    registrationController = new RegistrationController(registrationService);
  }

  @Test
  void showRegistrationPageReturnsRegister() {
    String viewName = registrationController.showRegistrationPage();
    assertEquals("register", viewName);
  }

  @Test
  void registerRedirectsToLogin() {
    Client client = new Client("John", "john@example.com", "password");
    String redirectUrl = registrationController.register(client);
    assertEquals("redirect:/login", redirectUrl);
    verify(registrationService, times(1)).registerNewClient(client);
  }
}

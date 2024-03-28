package com.example.GroceryShop.application.controller;

import com.example.GroceryShop.application.service.register.RegistrationService;
import com.example.GroceryShop.domain.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

  private final RegistrationService registrationService;

  @Autowired
  public RegistrationController(RegistrationService registrationService) {
    this.registrationService = registrationService;
  }

  @GetMapping("/register")
  public String showRegistrationPage() {
    return "register";
  }

  @PostMapping("/register")
  public String register(@ModelAttribute("client") Client client) {
    registrationService.registerNewClient(client);
    return "redirect:/login";
  }
}

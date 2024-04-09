package com.example.GroceryShop.application.controller;

import com.example.GroceryShop.domain.model.Client;
import com.example.GroceryShop.domain.model.ClientRole;
import com.example.GroceryShop.domain.model.Role;
import com.example.GroceryShop.infrastructure.repository.ClientRepository;
import com.example.GroceryShop.infrastructure.repository.ClientRoleRepository;
import com.example.GroceryShop.infrastructure.repository.RoleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

  private final ClientRepository clientRepository;

  private final RoleRepository roleRepository;

  private final ClientRoleRepository clientRoleRepository;

  public RegistrationController(
      ClientRepository clientRepository,
      RoleRepository roleRepository,
      ClientRoleRepository clientRoleRepository) {
    this.clientRepository = clientRepository;
    this.roleRepository = roleRepository;
    this.clientRoleRepository = clientRoleRepository;
  }

  @GetMapping("/register")
  public String showRegistrationForm(Model model) {
    model.addAttribute("client", new Client());
    return "register";
  }

  @PostMapping("/register")
  public String registerClient(@ModelAttribute("client") Client client) {
    System.out.println(client);
    Client save = clientRepository.save(client);
    // Tworzenie roli USER

    Role userRole = roleRepository.findByName("USER");
    if (userRole == null) {
      userRole = new Role("USER");
      userRole = roleRepository.save(userRole);
    }

    // Dodawanie roli do klienta
    save.getRoles().add(userRole);
    clientRepository.save(save);
    // Zapisywanie klienta

    // Tworzenie ClientRole i zapisywanie
    ClientRole clientRole = new ClientRole();
    clientRole.setRole(userRole);
    clientRole.setClient(save);
    clientRoleRepository.save(clientRole);

    System.out.println(clientRepository.findByUserName("figo96"));
    return "redirect:/home";
  }
}

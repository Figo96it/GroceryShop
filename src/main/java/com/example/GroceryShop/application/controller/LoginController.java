package com.example.GroceryShop.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @PostMapping("/login")
  public String showHomePage(){
    return "home";
  }

}

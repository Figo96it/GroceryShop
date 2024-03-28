package com.example.GroceryShop.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping("/home")
  public String showHomePage() {
    return "home";
  }

  @GetMapping("/")
  public String showHomePageOne() {
    return "home";
  }
}

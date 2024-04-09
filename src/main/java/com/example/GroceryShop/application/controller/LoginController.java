package com.example.GroceryShop.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

  @PostMapping("/home")
  public String login(@RequestParam(name = "error", required = false) String error, Model model) {
    if (error != null) {
      model.addAttribute("loginError", true);
      System.out.println("!! error");
    }
    System.out.println("!! not error");
    return "home";
  }
}

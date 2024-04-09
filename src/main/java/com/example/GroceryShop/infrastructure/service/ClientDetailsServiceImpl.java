package com.example.GroceryShop.infrastructure.service;

import com.example.GroceryShop.application.service.ClientService;
import com.example.GroceryShop.domain.model.Client;
import java.util.HashSet;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ClientDetailsServiceImpl implements UserDetailsService {

  private final ClientService clientService;

  public ClientDetailsServiceImpl(ClientService clientService) {
    this.clientService = clientService;
  }

  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    Client client = clientService.findByUserName(userName);
    if (client == null) {
      throw new UsernameNotFoundException("User not found");
    }
    return buildUserDetails(client);
  }

  private UserDetails buildUserDetails(Client client) {
    Set<GrantedAuthority> authorities = new HashSet<>();
    client.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));

    return new User(client.getUserName(), client.getPassword(), authorities);
  }
}

package com.example.GroceryShop.infrastructure.service;

import com.example.GroceryShop.domain.model.Client;
import com.example.GroceryShop.infrastructure.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.stream.Collectors;

public class ClientDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = clientRepository.findByUsername(username);
        if (client == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        Collection<? extends GrantedAuthority> authorities = client.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
        
        return new org.springframework.security.core.userdetails.User(client.getUsername(), client.getPassword(), authorities);
    }
}

package com.example.GroceryShop.infrastructure.security;

import com.example.GroceryShop.infrastructure.service.ClientDetailsServiceImpl;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Autowired
  private ClientDetailsServiceImpl clientDetailsServiceImpl;

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public AuthenticationManager authenticationManager() throws Exception {
    return new ProviderManager(Collections.singletonList(daoAuthenticationProvider()));
  }

  @Bean
  public DaoAuthenticationProvider daoAuthenticationProvider() {
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setUserDetailsService(clientDetailsServiceImpl);
    provider.setPasswordEncoder(passwordEncoder());
    return provider;
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests((authorize) -> authorize
                    .requestMatchers("/home")
                    .permitAll()
                    .anyRequest()
                    .authenticated())
            .formLogin(login -> login
                    .loginPage("/login")
                    .permitAll()
                    .defaultSuccessUrl("/home", true)
                    .failureUrl("/login?error=true"))
            .logout(LogoutConfigurer::permitAll);

    return http.build();
  }

}

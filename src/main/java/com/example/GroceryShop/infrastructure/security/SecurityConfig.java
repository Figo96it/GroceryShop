package com.example.GroceryShop.infrastructure.security;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

import com.example.GroceryShop.application.service.ClientService;
import com.example.GroceryShop.infrastructure.service.ClientDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Autowired private ClientService clientService;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.formLogin(
            form ->
                form.loginPage("/home")
                    .permitAll()
                    .defaultSuccessUrl("/home2")
                    .failureUrl("/home3"))
        .authorizeHttpRequests(
            (authorize) ->
                authorize
                    .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**"))
                    .permitAll()
                    .requestMatchers(new AntPathRequestMatcher("/**"))
                    .permitAll()
                    .anyRequest()
                    .authenticated())
            .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
            .csrf(csrf -> csrf
                    .ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")));

    return http.build();
  }

  @Bean
  public AuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setUserDetailsService(userDetailsService());
    provider.setPasswordEncoder(passwordEncoder());
    return provider;
  }

  //  @Bean
  //  public UserDetailsService userDetailsService() {
  //    UserDetails user =
  // User.builder().username("user").password("password").roles("USER").build();
  //
  //    return new InMemoryUserDetailsManager(user);
  //  }

  @Bean
  public UserDetailsService userDetailsService() {
    return new ClientDetailsServiceImpl(clientService);
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}

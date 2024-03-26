package com.example.GroceryShop.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

@Entity
@Data
@Table(name = "administrators")
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("ADMIN")
public class Administrator extends Client {

}

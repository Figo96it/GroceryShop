package com.example.GroceryShop.domain.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BIGINT")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id") // nazwa kolumny w bazie danych reprezentującej klucz obcy
    private Product product; // dodanie atrybutu product jako relacji do klasy Product
}

package com.adderly.backend_core.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "products") // La tabla en la BD se llamará 'products'
@Data
public class product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Double price;
    private String category; // Ej: "Electrónica", "Ropa"

    public product() {
    }

    public product(String name, String description, Double price, String category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }
}
package com.adderly.backend_core.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "interactions")
public class interaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private user user;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private product product;

    private String type; 
    private LocalDateTime timestamp; 

    // Constructor vacío
    public interaction() {
        this.timestamp = LocalDateTime.now();
    }

    // Constructor lleno
    public interaction(user user, product product, String type) {
        this.user = user;
        this.product = product;
        this.type = type;
        this.timestamp = LocalDateTime.now(); 
    }

    // --- AQUÍ ESTÁ LA SOLUCIÓN: GETTERS MANUALES ---
    // Estos métodos dejan que el navegador "vea" los datos

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public user getUser() { return user; }
    public void setUser(user user) { this.user = user; }

    public product getProduct() { return product; }
    public void setProduct(product product) { this.product = product; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
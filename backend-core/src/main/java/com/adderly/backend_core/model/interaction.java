package com.adderly.backend_core.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;




@Entity
@Table(name = "interactions")
public class interaction {
    
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación: Muchas interacciones -> Un Usuario
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private user user;

    // Relación: Muchas interacciones -> Un Producto
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private product product;

    private String type; // Ej: "CLICK", "BUY", "LIKE"
    
    private LocalDateTime timestamp; // Fecha y hora exacta

    // Constructor vacío
    public interaction() {
        this.timestamp = LocalDateTime.now();
    }

    // Constructor para crear interacciones rápido
    public interaction(user user, product product, String type) {
        this.user = user;
        this.product = product;
        this.type = type;
        this.timestamp = LocalDateTime.now(); // Pone la hora actual automática
    }
}

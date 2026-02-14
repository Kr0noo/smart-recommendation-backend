package com.adderly.backend_core.controller;

import com.adderly.backend_core.model.interaction;
import com.adderly.backend_core.model.product;
import com.adderly.backend_core.model.user;
import com.adderly.backend_core.repository.interactionrepository;
import com.adderly.backend_core.repository.productrepository;
import com.adderly.backend_core.repository.userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interactions")
public class interactioncontroller {

    @Autowired
    private interactionrepository interactionRepository;

    @Autowired
    private userrepository userRepository;

    @Autowired
    private productrepository productRepository;

    // 1. Ver todas las interacciones (Para que veas qué está pasando)
    @GetMapping
    public List<interaction> getAllInteractions() {
        return interactionRepository.findAll();
    }

    // 2. Guardar una interacción (El cerebro del sistema)
    @PostMapping
    public interaction createInteraction(@RequestBody InteractionRequest request) {
        // Buscamos al usuario en la base de datos
        user u = userRepository.findById(request.userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Buscamos el producto en la base de datos
        product p = productRepository.findById(request.productId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // Creamos la nueva interacción
        interaction i = new interaction(u, p, request.type);
        
        return interactionRepository.save(i);
    }

    // Una clasecita auxiliar para recibir los datos simples (ID de usuario y producto)
    // Esto ayuda a que el JSON sea limpio
    public static class InteractionRequest {
        public Long userId;
        public Long productId;
        public String type; // "CLICK", "BUY", "LIKE"
    }
}
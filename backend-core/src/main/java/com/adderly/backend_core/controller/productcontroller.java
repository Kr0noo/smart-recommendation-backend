package com.adderly.backend_core.controller;

import com.adderly.backend_core.model.product;
import com.adderly.backend_core.repository.productrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class productcontroller {

    @Autowired
    private productrepository productRepository;

    // 1. Ver todos los productos
    @GetMapping
    public List<product> getAllProducts() {
        return productRepository.findAll();
    }

    // 2. Crear un producto
    @PostMapping
    public product createProduct(@RequestBody product newProduct) {
        return productRepository.save(newProduct);
    }

    // 3. NUEVO: Filtrar recomendaciones por categoría
    // Este es el que te faltaba 👇
    @GetMapping("/recommend")
    public List<product> getRecommendations(@RequestParam String category) {
        return productRepository.findByCategory(category);
    }
}
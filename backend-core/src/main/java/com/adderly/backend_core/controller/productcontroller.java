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

    @GetMapping
    public List<product> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping
    public product createProduct(@RequestBody product newProduct) {
        return productRepository.save(newProduct);
    }
}
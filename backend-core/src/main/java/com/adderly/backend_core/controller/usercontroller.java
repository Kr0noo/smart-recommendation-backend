package com.adderly.backend_core.controller;

import com.adderly.backend_core.model.user; // Import minúscula
import com.adderly.backend_core.repository.userrepository; // Import minúscula
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class usercontroller { // <--- Nombre de clase en minúscula

    @Autowired
    private userrepository userRepository; // Tipo en minúscula

    @GetMapping
    public List<user> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public user createUser(@RequestBody user newUser) {
        return userRepository.save(newUser);
    }
}
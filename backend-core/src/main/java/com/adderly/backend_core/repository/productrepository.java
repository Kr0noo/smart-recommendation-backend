package com.adderly.backend_core.repository;

import com.adderly.backend_core.model.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List; // <--- 1. IMPORTANTE: Agregamos esto para usar listas

@Repository
public interface productrepository extends JpaRepository<product, Long> {
    
    // 2. IMPORTANTE: Esta es la instrucción que te faltaba
    List<product> findByCategory(String category);
}
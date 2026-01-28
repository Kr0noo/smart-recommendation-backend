package com.adderly.backend_core.repository;

import com.adderly.backend_core.model.user; // <--- Importamos 'user' en minúscula
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userrepository extends JpaRepository<user, Long> { 
    // <--- El nombre de la interfaz AHORA SÍ es minúscula 'userrepository'
}
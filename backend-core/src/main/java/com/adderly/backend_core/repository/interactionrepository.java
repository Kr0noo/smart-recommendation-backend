package com.adderly.backend_core.repository;

import com.adderly.backend_core.model.interaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


public interface interactionrepository extends JpaRepository<interaction, Long> {
    //Esto nos servira luego para ver que le gusta a un usuario en especifico
    List<interaction> findByUserId(Long userId);
    
}

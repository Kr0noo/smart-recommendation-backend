package com.adderly.backend_core.repository;

import com.adderly.backend_core.model.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productrepository extends JpaRepository<product, Long> {
}
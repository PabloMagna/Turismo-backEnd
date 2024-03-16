package com.turismo.turismo.repository;

import com.turismo.turismo.model.Paquete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaqueteRepository extends JpaRepository<Paquete,Long> {
}

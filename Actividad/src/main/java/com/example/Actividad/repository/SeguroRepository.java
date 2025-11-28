package com.example.Actividad.repository;

import com.example.Actividad.entity.Seguro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeguroRepository extends JpaRepository<Seguro, Long> {
    Boolean existsByNumeroPoliza(String numeroPoliza);
}

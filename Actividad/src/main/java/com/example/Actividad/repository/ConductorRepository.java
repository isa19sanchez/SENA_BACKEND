package com.example.Actividad.repository;

import com.example.Actividad.entity.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConductorRepository extends JpaRepository<Conductor,Long> {
    Boolean existsByConductorName(String conductorName);
}

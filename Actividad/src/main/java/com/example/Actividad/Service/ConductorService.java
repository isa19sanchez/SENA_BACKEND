package com.example.Actividad.Service;

import com.example.Actividad.entity.Conductor;

import java.util.List;
import java.util.Optional;

public interface ConductorService {
    Conductor registerConductor(Conductor conductor);
    List<Conductor> listConductor();

    Optional<Conductor> searchConductorById(Long conductorId);

    Conductor updateConductor(Long conductorId, Conductor conductor);

    void deleteConductor(Long conductorId);
}

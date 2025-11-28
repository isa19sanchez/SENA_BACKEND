package com.example.Actividad.Service;

import com.example.Actividad.entity.Seguro;

import java.util.List;
import java.util.Optional;

public interface SeguroService {

    Seguro registerSeguro(Seguro seguro);

    List<Seguro> listSeguros();

    Optional<Seguro> searchSeguroById(Long seguroId);

    Seguro updateSeguro(Long seguroId, Seguro seguro);

    void deleteSeguro(Long seguroId);
}


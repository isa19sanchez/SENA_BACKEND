package com.example.Actividad.Service;

import com.example.Actividad.entity.Vehiculo;

import java.util.List;

public interface VehiculoService {
    Vehiculo registerVehiculo(Vehiculo vehiculo);

    List<Vehiculo> listVehiculos();

    Vehiculo updateVehiculo(Long idVehiculo, Vehiculo vehiculo) throws Exception;

    void deleteVehiculo(Long idVehiculo);
}

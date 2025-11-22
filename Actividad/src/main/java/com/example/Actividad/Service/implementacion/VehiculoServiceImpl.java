package com.example.Actividad.Service.implementacion;

import com.example.Actividad.Service.VehiculoService;
import com.example.Actividad.entity.Vehiculo;
import com.example.Actividad.repository.VehiculoRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoServiceImpl implements VehiculoService {
    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Override
    public Vehiculo registerVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    @Override
    public List<Vehiculo> listVehiculos() {
        return  vehiculoRepository.findAll();
    }

    @Override
    public Vehiculo updateVehiculo(Long idVehiculo, Vehiculo vehiculo) throws Exception {
        Vehiculo vehiculoExisting = vehiculoRepository.findByidVehiculo(idVehiculo)
                .orElseThrow(() -> new Exception("Vehiculo con el Id " + idVehiculo + " no encontrado"));

        vehiculoExisting.setPlacaVehiculo(vehiculo.getPlacaVehiculo());
        vehiculoExisting.setMarcaVehiculo(vehiculo.getMarcaVehiculo());
        vehiculoExisting.setModeloVehiculo(vehiculo.getModeloVehiculo());
        vehiculoExisting.setVehiculoYear(vehiculo.getVehiculoYear());
        vehiculoExisting.setColorVehiculo(vehiculo.getColorVehiculo());
        return vehiculoRepository.save(vehiculoExisting);
    }

    @SneakyThrows
    @Override
    public void deleteVehiculo(Long idVehiculo) {
        Vehiculo vehiculoExisting = vehiculoRepository.findByidVehiculo(idVehiculo)
                .orElseThrow(()-> new Exception("El vehiculo con el Id " + idVehiculo + " no existe"));
        vehiculoRepository.deleteById(idVehiculo);
    }
}

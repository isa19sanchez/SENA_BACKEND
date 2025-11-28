package com.example.Actividad.Service.implementacion;

import com.example.Actividad.Service.ConductorService;
import com.example.Actividad.entity.Conductor;
import com.example.Actividad.repository.ConductorRepository;
import lombok.SneakyThrows;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConductorServiceImpl implements ConductorService {

    @Autowired
    private ConductorRepository conductorRepository;

    @Override
    @SneakyThrows
    public Conductor registerConductor(Conductor conductor) {
        if (conductorRepository.existsByConductorName(conductor.getConductorName())) {
            throw new BadRequestException("Conductor already exists");
        }else {
            return conductorRepository.save(conductor);
        }
    }

    @Override
    public List<Conductor> listConductor() {
        return conductorRepository.findAll();
    }

    @Override
    public Optional<Conductor> searchConductorById(Long conductorId) {
        return conductorRepository.findById(conductorId);
    }

    @Override
    @SneakyThrows
    public Conductor updateConductor(Long conductorId, Conductor conductor) {

        Conductor conductorExisting = conductorRepository.findById(conductorId)
                .orElseThrow(() -> new Exception("Conductor with ID " + conductorId + " NOT FOUND"));

        conductorExisting.setConductorName(conductor.getConductorName());
        conductorExisting.setIdLicencia(conductor.getIdLicencia());
        conductorExisting.setIdTelefono(conductor.getIdTelefono());
        conductorExisting.setIdDireccion(conductor.getIdDireccion());
        conductorExisting.setIdActivo(conductor.isIdActivo());

        return conductorRepository.save(conductorExisting);
    }


    @Override
    @SneakyThrows
    public void deleteConductor(Long conductorId) {
        Conductor conductorExisting = conductorRepository.findById(conductorId)
                .orElseThrow(()-> new Exception("Conductor with ID" + conductorId +"NOT FOUND"));

        conductorRepository.deleteById(conductorId);
    }
}

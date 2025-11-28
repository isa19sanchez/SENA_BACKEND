package com.example.Actividad.Service.implementacion;

import com.example.Actividad.Service.SeguroService;
import com.example.Actividad.entity.Seguro;
import com.example.Actividad.repository.SeguroRepository;
import lombok.SneakyThrows;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeguroServiceImpl implements SeguroService {

    @Autowired
    private SeguroRepository seguroRepository;

    @Override
    @SneakyThrows
    public Seguro registerSeguro(Seguro seguro) {

        if (seguroRepository.existsByNumeroPoliza(seguro.getNumeroPoliza())) {
            throw new BadRequestException("Seguro already exists");
        } else {
            return seguroRepository.save(seguro);
        }
    }

    @Override
    public List<Seguro> listSeguros() {
        return seguroRepository.findAll();
    }

    @Override
    public Optional<Seguro> searchSeguroById(Long seguroId) {
        return seguroRepository.findById(seguroId);
    }

    @Override
    @SneakyThrows
    public Seguro updateSeguro(Long seguroId, Seguro seguro) {

        Seguro seguroExisting = seguroRepository.findById(seguroId)
                .orElseThrow(() -> new Exception("Seguro with ID " + seguroId + " NOT FOUND"));

        seguroExisting.setCompania(seguro.getCompania());
        seguroExisting.setNumeroPoliza(seguro.getNumeroPoliza());
        seguroExisting.setFechaInicio(seguro.getFechaInicio());
        seguroExisting.setFechaVencimiento(seguro.getFechaVencimiento());

        return seguroRepository.save(seguroExisting);
    }

    @Override
    @SneakyThrows
    public void deleteSeguro(Long seguroId) {

        Seguro seguroExisting = seguroRepository.findById(seguroId)
                .orElseThrow(() -> new Exception("Seguro with ID " + seguroId + " NOT FOUND"));

        seguroRepository.deleteById(seguroId);
    }
}

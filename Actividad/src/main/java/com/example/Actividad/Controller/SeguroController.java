package com.example.Actividad.Controller;

import com.example.Actividad.Service.SeguroService;
import com.example.Actividad.entity.Seguro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/seguro")
public class SeguroController {

    @Autowired
    private SeguroService seguroService;

    // Registrar un seguro
    @PostMapping("/register")
    public ResponseEntity<Seguro> registerSeguro(@RequestBody Seguro seguro) {
        Seguro newSeguro = seguroService.registerSeguro(seguro);
        return new ResponseEntity<>(newSeguro, HttpStatus.CREATED);
    }

    // Listar todos los seguros
    @GetMapping("/list")
    public ResponseEntity<List<Seguro>> listSeguros() {
        List<Seguro> seguros = seguroService.listSeguros();
        return new ResponseEntity<>(seguros, HttpStatus.OK);
    }

    // Buscar seguro por ID
    @GetMapping("/{seguroId}")
    public ResponseEntity<Seguro> searchSeguroById(@PathVariable Long seguroId) throws Exception {
        Optional<Seguro> seguro = seguroService.searchSeguroById(seguroId);

        if (seguro.isPresent()) {
            return new ResponseEntity<>(seguro.get(), HttpStatus.OK);
        } else {
            throw new Exception("Seguro not found");
        }
    }

    // Actualizar seguro
    @PutMapping("/update/{seguroId}")
    public ResponseEntity<Seguro> updateSeguro(
            @PathVariable Long seguroId,
            @RequestBody Seguro seguro) {

        try {
            Seguro updatedSeguro = seguroService.updateSeguro(seguroId, seguro);

            if (updatedSeguro != null) {
                return new ResponseEntity<>(updatedSeguro, HttpStatus.OK);
            } else {
                throw new Exception("Seguro not found");
            }

        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar seguro
    @DeleteMapping("/delete/{seguroId}")
    public ResponseEntity<Void> deleteSeguro(@PathVariable Long seguroId) {

        try {
            seguroService.deleteSeguro(seguroId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


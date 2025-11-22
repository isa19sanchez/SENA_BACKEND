package com.example.Actividad.Controller;

import com.example.Actividad.Service.VehiculoService;
import com.example.Actividad.entity.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculo")
public class SegurosController {

    @Autowired
    private VehiculoService vehiculoService;

    @PostMapping("/register")
    public ResponseEntity<?> registrarVehiculo(@RequestBody Vehiculo vehiculo){
        Vehiculo newVehiculo = vehiculoService.registerVehiculo(vehiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newVehiculo);
    }

    @GetMapping("/list")
    public ResponseEntity<?> listarVehiculos() {
        List<Vehiculo> vehiculos = vehiculoService.listVehiculos();
        return ResponseEntity.ok(vehiculos);
    }

    @PutMapping("/update/{idVehiculo}")
    public ResponseEntity<?> updateVehiculo(@PathVariable Long idVehiculo, @RequestBody Vehiculo vehiculo){
        try {
            Vehiculo updateVehciulo = new Vehiculo();
            updateVehciulo.setPlacaVehiculo(vehiculo.getPlacaVehiculo());
            updateVehciulo.setMarcaVehiculo(vehiculo.getMarcaVehiculo());
            updateVehciulo.setModeloVehiculo(vehiculo.getModeloVehiculo());
            updateVehciulo.setVehiculoYear(vehiculo.getVehiculoYear());
            updateVehciulo.setColorVehiculo(vehiculo.getColorVehiculo());

            Vehiculo vehiculoDB = vehiculoService.updateVehiculo(idVehiculo, updateVehciulo);
            return ResponseEntity.ok(vehiculoDB);
        }catch (Exception exception){
            System.out.println( exception.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

    @DeleteMapping("/delete/{idVehiculo}")
    public ResponseEntity<?> deleteVehiculo(@PathVariable Long idVehiculo){
        try {
            vehiculoService.deleteVehiculo(idVehiculo);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }
}


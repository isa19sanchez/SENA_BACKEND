package com.example.Actividad.Controller;

import com.example.Actividad.Service.ConductorService;
import com.example.Actividad.entity.Conductor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/conductor")
public class ConductorController {

    @Autowired
    private ConductorService conductorService;

    @PostMapping("/register")
    public ResponseEntity<Conductor> registerConductor(@RequestBody Conductor conductor) {
        Conductor newConductor = conductorService.registerConductor(conductor);
        return new ResponseEntity<>(newConductor, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Conductor>> listConductor() {
        List<Conductor> conductores = conductorService.listConductor();
        return new ResponseEntity<>(conductores , HttpStatus.OK);
    }

    @GetMapping("/{conductorId}")
    public ResponseEntity<Conductor> searchConductorById(@PathVariable Long conductorId) throws Exception {
        Optional<Conductor> conductor = conductorService.searchConductorById(conductorId);

        if (conductor.isPresent()) {
            return new ResponseEntity<>(conductor.get(),HttpStatus.OK);


        }else {
            throw new Exception("category not found");
        }
    }

    @PutMapping("/update/{conductorId}")
    public ResponseEntity<Conductor> updatedConductor(@PathVariable Long conductorId, @RequestBody Conductor conductor) {
        try {
            Conductor updatedConductor = conductorService.updateConductor(conductorId,conductor);
            if (updatedConductor !=null) {
                return new ResponseEntity<>(updatedConductor,HttpStatus.OK);
            }else {
                throw new Exception("Conductor not found");
            }
        }catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{conductorId}")
    public ResponseEntity<Void> deleteConductor(@PathVariable Long conductorId) {
        try{
            conductorService.deleteConductor(conductorId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

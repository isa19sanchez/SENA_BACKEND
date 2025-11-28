package com.example.Actividad.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Vehiculo {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "idVehiculo")
    private Long idVehiculo;

    @Column(name = "placaVehiculo", nullable = false)
    private String placaVehiculo;

    @Column(name = "marcaVehiculo", nullable = false)
    private String marcaVehiculo;

    @Column(name = "modeloVehiculo", nullable = false, length = 100)
    private String modeloVehiculo;

    @Column(name = "vehiculoYear", nullable = false)
    private Integer vehiculoYear;

    @Column(name = "colorVehiculo", nullable = false, length = 100)
    private String colorVehiculo;

    @OneToOne
    @JoinColumn(name = "id_conductor", unique = true)
    private Conductor conductor;


    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL)
    private List<Seguro> seguros;

}

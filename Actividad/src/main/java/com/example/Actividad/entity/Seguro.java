package com.example.Actividad.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "seguros")
@Data
public class Seguro {

    @ManyToOne
    @JoinColumn(name = "idVehiculo")
    private Vehiculo vehiculo;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "seguroId")
    private Long seguroId;

    @Column(name = "compania")
    private String compania;

    @Column(name = "numeroPoliza")
    private String numeroPoliza;

    @Column(name = "fechaInicio")
    private LocalDate fechaInicio;

    @Column(name = "fechaVencimiento")
    private LocalDate fechaVencimiento;

}


package com.example.Actividad.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "conductores")
@Data
public class Conductor {

    @OneToOne(mappedBy = "conductor")
    private Vehiculo vehiculo;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "conductorId")

    private Long conductorId;

    @Column(name = "conductorName")
    private String conductorName;

    @Column(name = "idLicencia")
    private String idLicencia;

    @Column(name = "idTelefono")
    private String idTelefono;

    @Column(name = "idDireccion")
    private String idDireccion;

    @Column(name = "idActivo")
    private boolean idActivo;
}

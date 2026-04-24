package com.prueba.tecnicaapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float valor;
    private LocalDate fecha_registro;
    //Alumno
    @ManyToOne
    private Alumno alumno;
    //Materia
    @ManyToOne
    private Materia materia;

}

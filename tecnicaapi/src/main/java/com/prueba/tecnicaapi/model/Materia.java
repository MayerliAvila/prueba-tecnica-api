package com.prueba.tecnicaapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int codigo;
    private Long credito;
    @OneToMany(mappedBy = "materia", cascade = CascadeType.ALL)
    private List<Nota> notas;
}

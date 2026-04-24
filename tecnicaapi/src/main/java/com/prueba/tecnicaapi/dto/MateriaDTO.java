package com.prueba.tecnicaapi.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MateriaDTO {
    private Long id;
    private String nombre;
    private int codigo;
    private Long credito;
}

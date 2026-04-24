package com.prueba.tecnicaapi.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotaDTO {
    private Long id;
    private Float valor;
    private LocalDate fecha_registro;
    private Long idAlumno;
    private Long idMateria;

}

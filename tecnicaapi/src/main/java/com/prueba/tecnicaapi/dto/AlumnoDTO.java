package com.prueba.tecnicaapi.dto;

import jdk.jshell.Snippet;
import lombok.*;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlumnoDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private Date fecha_nacimiento;

}

package com.prueba.tecnicaapi.mapper;

import com.prueba.tecnicaapi.dto.AlumnoDTO;
import com.prueba.tecnicaapi.dto.MateriaDTO;
import com.prueba.tecnicaapi.dto.NotaDTO;
import com.prueba.tecnicaapi.model.Alumno;
import com.prueba.tecnicaapi.model.Materia;
import com.prueba.tecnicaapi.model.Nota;

public class Mapper {

    //Mapper de Alumno a AlumnoDTO
    public static AlumnoDTO toDTO(Alumno a){
        if (a == null) return null;

        return AlumnoDTO.builder()
                .id(a.getId())
                .nombre(a.getNombre())
                .apellido(a.getApellido())
                .email(a.getEmail())
                .fecha_nacimiento(a.getFecha_nacimiento())
                .build();
    }

    //Mapper de Materia a MateriaDTO
    public static MateriaDTO toDTO(Materia m){
        if (m == null) return null;

        return MateriaDTO.builder()
                .id(m.getId())
                .nombre(m.getNombre())
                .codigo(m.getCodigo())
                .credito(m.getCredito())
                .build();
    }

    //Mapper de Nota a NotaDTO
    public static NotaDTO toDTO(Nota n) {
        NotaDTO dto = new NotaDTO();

        dto.setId(n.getId());
        dto.setValor(n.getValor());
        dto.setFecha_registro(n.getFecha_registro());

        dto.setIdAlumno(n.getAlumno().getId());
        dto.setIdMateria(n.getMateria().getId());

        // 🔥 ESTA LÍNEA ES LA CLAVE
        dto.setMateriaNombre(n.getMateria().getNombre());

        return dto;
    }
}
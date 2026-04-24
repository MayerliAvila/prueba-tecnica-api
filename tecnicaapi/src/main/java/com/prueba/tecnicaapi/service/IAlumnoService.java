package com.prueba.tecnicaapi.service;

import com.prueba.tecnicaapi.dto.AlumnoDTO;

import java.util.List;

public interface IAlumnoService {
    AlumnoDTO crearAlumno(AlumnoDTO alumnoDto);
    List<AlumnoDTO> traerAlumnos();
    AlumnoDTO obtenerAlumnoPorId(Long id);
    AlumnoDTO actualizarAlumno(Long id, AlumnoDTO alumnoDto);
    void eliminarAlumno(Long id);
}

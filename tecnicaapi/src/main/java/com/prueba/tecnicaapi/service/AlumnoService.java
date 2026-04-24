package com.prueba.tecnicaapi.service;

import com.prueba.tecnicaapi.dto.AlumnoDTO;
import com.prueba.tecnicaapi.exception.NotFoundException;
import com.prueba.tecnicaapi.mapper.Mapper;
import com.prueba.tecnicaapi.model.Alumno;
import com.prueba.tecnicaapi.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class AlumnoService implements IAlumnoService {
    @Autowired
    private AlumnoRepository repo;

    // Crear Alumno
    @Override
    public AlumnoDTO crearAlumno(AlumnoDTO alumnoDto) {
        Alumno alumno = Alumno.builder()
                .nombre(alumnoDto.getNombre())
                .apellido(alumnoDto.getApellido())
                .email(alumnoDto.getEmail())
                .fecha_nacimiento(alumnoDto.getFecha_nacimiento())
                .build();
        return Mapper.toDTO(repo.save(alumno));
    }
    // Listar todas
    @Override
    public List<AlumnoDTO> traerAlumnos() {
        return repo.findAll().stream().map(Mapper::toDTO).toList();
    }
    // Buscar por ID
    @Override
    public AlumnoDTO obtenerAlumnoPorId(Long id) {
        Alumno alumno = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Alumno no encontrado"));

        return Mapper.toDTO(alumno);
    }
    // Actualizar Alumno
    @Override
    public AlumnoDTO actualizarAlumno(Long id, AlumnoDTO alumnoDto) {
        Alumno alumno = repo.findById(id)
        .orElseThrow(()-> new NotFoundException("Alumno no encontrado"));
        alumno.setNombre(alumnoDto.getNombre());
        alumno.setApellido(alumnoDto.getApellido());
        alumno.setEmail(alumnoDto.getEmail());
        alumno.setFecha_nacimiento(alumnoDto.getFecha_nacimiento());
        return Mapper.toDTO(repo.save(alumno));
    }
    //Eliminar Alumno
    @Override
    public void eliminarAlumno(Long id) {
        if(!repo.existsById(id)){
            throw new NotFoundException("Alumno no encontrado");
        }
        repo.deleteById(id);


    }
}

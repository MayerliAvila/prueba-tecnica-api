package com.prueba.tecnicaapi.service;

import com.prueba.tecnicaapi.dto.NotaDTO;
import com.prueba.tecnicaapi.exception.NotFoundException;
import com.prueba.tecnicaapi.mapper.Mapper;
import com.prueba.tecnicaapi.model.Alumno;
import com.prueba.tecnicaapi.model.Materia;
import com.prueba.tecnicaapi.model.Nota;
import com.prueba.tecnicaapi.repository.AlumnoRepository;
import com.prueba.tecnicaapi.repository.MateriaRepository;
import com.prueba.tecnicaapi.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaService implements INotaService {

    @Autowired
    private NotaRepository repo;

    @Autowired
    private AlumnoRepository alumnoRepo;

    @Autowired
    private MateriaRepository materiaRepo;

    // Registrar nota
    @Override
    public NotaDTO registrarNota(NotaDTO notaDTO) {

        Alumno alumno = alumnoRepo.findById(notaDTO.getIdAlumno())
                .orElseThrow(() -> new NotFoundException("Alumno no encontrado"));

        Materia materia = materiaRepo.findById(notaDTO.getIdMateria())
                .orElseThrow(() -> new NotFoundException("Materia no encontrada"));

        Nota nota = Nota.builder()
                .valor(notaDTO.getValor())
                .fecha_registro(notaDTO.getFecha_registro())
                .alumno(alumno)
                .materia(materia)
                .build();

        return Mapper.toDTO(repo.save(nota));
    }

    // Listar notas por alumno
    @Override
    public List<NotaDTO> obtenerNotasPorAlumno(Long idAlumno) {
        return repo.findByAlumnoId(idAlumno)
                .stream()
                .map(Mapper::toDTO)
                .toList();
    }

    // Listar notas por alumno y materia
    @Override
    public List<NotaDTO> obtenerNotasPorAlumnoYMateria(Long idAlumno, Long idMateria) {
        return repo.findByAlumnoIdAndMateriaId(idAlumno, idMateria)
                .stream()
                .map(Mapper::toDTO)
                .toList();
    }
}
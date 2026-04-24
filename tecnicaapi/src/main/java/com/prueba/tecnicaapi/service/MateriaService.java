package com.prueba.tecnicaapi.service;

import com.prueba.tecnicaapi.dto.MateriaDTO;
import com.prueba.tecnicaapi.exception.NotFoundException;
import com.prueba.tecnicaapi.mapper.Mapper;
import com.prueba.tecnicaapi.model.Materia;
import com.prueba.tecnicaapi.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaService implements IMateriaService {

    @Autowired
    private MateriaRepository repo;

    // Crear materia
    @Override
    public MateriaDTO crearMateria(MateriaDTO materiaDto) {
        Materia materia = Materia.builder()
                .nombre(materiaDto.getNombre())
                .codigo(materiaDto.getCodigo())
                .credito(materiaDto.getCredito())
                .build();

        return Mapper.toDTO(repo.save(materia));
    }

    // Listar todas
    @Override
    public List<MateriaDTO> traerMaterias() {
        return repo.findAll().stream().map(Mapper::toDTO).toList();
    }

    // Buscar por ID
    @Override
    public MateriaDTO obtenerMateriaPorId(Long id) {
        Materia materia = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Materia no encontrada"));

        return Mapper.toDTO(materia);
    }

    // Actualizar Materia
    @Override
    public MateriaDTO actualizarMateria(Long id, MateriaDTO materiaDto) {
        Materia materia = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Materia no encontrada"));

        materia.setNombre(materiaDto.getNombre());
        materia.setCodigo(materiaDto.getCodigo());
        materia.setCredito(materiaDto.getCredito());

        return Mapper.toDTO(repo.save(materia));
    }

    // Eliminar Materia
    @Override
    public void eliminarMateria(Long id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("Materia no encontrada");
        }
        repo.deleteById(id);
    }
}
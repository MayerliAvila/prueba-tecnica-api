package com.prueba.tecnicaapi.service;

import com.prueba.tecnicaapi.dto.MateriaDTO;

import java.util.List;

public interface IMateriaService {
    MateriaDTO crearMateria(MateriaDTO materiaDto);
    List<MateriaDTO> traerMaterias();
    MateriaDTO obtenerMateriaPorId(Long id);
    MateriaDTO actualizarMateria(Long id, MateriaDTO materiaDto);
    void eliminarMateria(Long id);

}

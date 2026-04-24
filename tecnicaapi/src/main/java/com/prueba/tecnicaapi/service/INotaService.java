package com.prueba.tecnicaapi.service;

import com.prueba.tecnicaapi.dto.NotaDTO;
import java.util.List;

public interface INotaService {

    NotaDTO registrarNota(NotaDTO notaDTO);
    List<NotaDTO> obtenerNotasPorAlumno(Long idAlumno);
    List<NotaDTO> obtenerNotasPorAlumnoYMateria(Long idAlumno, Long idMateria);
}
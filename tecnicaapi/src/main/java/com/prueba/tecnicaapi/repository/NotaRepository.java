package com.prueba.tecnicaapi.repository;

import com.prueba.tecnicaapi.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotaRepository extends JpaRepository<Nota, Long> {

    // 🔹 Listar notas por alumno
    List<Nota> findByAlumnoId(Long idAlumno);

    // 🔹 Listar notas por materia
    List<Nota> findByMateriaId(Long idMateria);

    // 🔹 Listar notas por alumno y materia
    List<Nota> findByAlumnoIdAndMateriaId(Long idAlumno, Long idMateria);
}
package com.prueba.tecnicaapi.repository;

import com.prueba.tecnicaapi.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotaRepository extends JpaRepository<Nota, Long> {

    // 🔥 CORREGIDO (trae materia)
    @Query("SELECT n FROM Nota n JOIN FETCH n.materia WHERE n.alumno.id = :idAlumno")
    List<Nota> findByAlumnoId(@Param("idAlumno") Long idAlumno);

    // 🔹 Listar notas por materia
    List<Nota> findByMateriaId(Long idMateria);

    // 🔹 Listar notas por alumno y materia
    List<Nota> findByAlumnoIdAndMateriaId(Long idAlumno, Long idMateria);
}
package com.prueba.tecnicaapi.repository;

import com.prueba.tecnicaapi.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository <Alumno, Long> {
}

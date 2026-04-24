package com.prueba.tecnicaapi.repository;

import com.prueba.tecnicaapi.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MateriaRepository extends JpaRepository<Materia, Long> {
}

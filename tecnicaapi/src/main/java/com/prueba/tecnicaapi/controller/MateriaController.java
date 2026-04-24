package com.prueba.tecnicaapi.controller;

import com.prueba.tecnicaapi.dto.MateriaDTO;
import com.prueba.tecnicaapi.service.IMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/materias")
public class MateriaController {

    @Autowired
    private IMateriaService materiaService;

    // Crear materia
    @PostMapping
    public ResponseEntity<MateriaDTO> crearMateria(@RequestBody MateriaDTO materiaDTO) {
        MateriaDTO creada = materiaService.crearMateria(materiaDTO);
        return ResponseEntity
                .created(URI.create("/api/materias/" + creada.getId()))
                .body(creada);
    }

    // Listar todas las materias
    @GetMapping
    public ResponseEntity<List<MateriaDTO>> traerMaterias() {
        return ResponseEntity.ok(materiaService.traerMaterias());
    }

    // Obtener materia por ID
    @GetMapping("/{id}")
    public ResponseEntity<MateriaDTO> obtenerMateriaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(materiaService.obtenerMateriaPorId(id));
    }

    // Actualizar materia
    @PutMapping("/{id}")
    public ResponseEntity<MateriaDTO> actualizarMateria(@PathVariable Long id,
                                                        @RequestBody MateriaDTO materiaDTO) {
        return ResponseEntity.ok(materiaService.actualizarMateria(id, materiaDTO));
    }

    // Eliminar materia
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMateria(@PathVariable Long id) {
        materiaService.eliminarMateria(id);
        return ResponseEntity.noContent().build();
    }
}
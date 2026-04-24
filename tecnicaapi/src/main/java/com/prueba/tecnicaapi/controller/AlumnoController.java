package com.prueba.tecnicaapi.controller;

import com.prueba.tecnicaapi.dto.AlumnoDTO;
import com.prueba.tecnicaapi.service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    @Autowired
    private IAlumnoService alumnoService;
    // Crear Usuario
    @PostMapping
    public ResponseEntity<AlumnoDTO> crearAlumno(@RequestBody AlumnoDTO dto) {
        AlumnoDTO creado = alumnoService.crearAlumno(dto);
        return ResponseEntity
                .created(URI.create("/api/alumnos/" + creado.getId()))
                .body(creado);
    }
    // Listar todas los alunmos
    @GetMapping
    public ResponseEntity<List<AlumnoDTO>> traerAlumnos() {
        return ResponseEntity.ok(alumnoService.traerAlumnos());
    }
    // Obtener alumno por ID
    @GetMapping("/{id}")
    public ResponseEntity<AlumnoDTO> obtenerAlumnoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(alumnoService.obtenerAlumnoPorId(id));
    }
    // Actualizar alumno
    @PutMapping("/{id}")
    public ResponseEntity<AlumnoDTO> actualizarAlumno(@PathVariable Long id,
                                                      @RequestBody AlumnoDTO dto) {
        return ResponseEntity.ok(alumnoService.actualizarAlumno(id, dto));
    }
    // Eliminar alumno
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAlumno(@PathVariable Long id) {
        alumnoService.eliminarAlumno(id);
        return ResponseEntity.noContent().build();
    }
}
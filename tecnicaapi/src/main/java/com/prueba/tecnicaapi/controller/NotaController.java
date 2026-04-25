package com.prueba.tecnicaapi.controller;

import com.prueba.tecnicaapi.dto.NotaDTO;
import com.prueba.tecnicaapi.service.INotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/notas")
public class NotaController {

    @Autowired
    private INotaService notaService;

    //Registrar una nota
    @PostMapping
    public ResponseEntity<NotaDTO> registrarNota(@RequestBody NotaDTO notaDTO) {
        NotaDTO creada = notaService.registrarNota(notaDTO);
        return ResponseEntity.ok(creada);

    }
    // Listar notas por alumno
    @GetMapping("/alumno/{idAlumno}")
    public ResponseEntity<List<NotaDTO>> obtenerNotasPorAlumno(@PathVariable Long idAlumno) {
        return ResponseEntity.ok(notaService.obtenerNotasPorAlumno(idAlumno));
    }

    // Listar notas por alumno y materia
    @GetMapping("/alumno/{idAlumno}/materia/{idMateria}")
    public ResponseEntity<List<NotaDTO>> obtenerNotasPorAlumnoYMateria(
            @PathVariable Long idAlumno,
            @PathVariable Long idMateria) {

        return ResponseEntity.ok(
                notaService.obtenerNotasPorAlumnoYMateria(idAlumno, idMateria)
        );
    }
}
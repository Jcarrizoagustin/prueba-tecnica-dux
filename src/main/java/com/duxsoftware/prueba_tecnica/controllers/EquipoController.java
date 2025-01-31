package com.duxsoftware.prueba_tecnica.controllers;

import com.duxsoftware.prueba_tecnica.model.Equipo;
import com.duxsoftware.prueba_tecnica.services.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("equipos")
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    @GetMapping
    public ResponseEntity<List<Equipo>> obtenerTodosLosEquipos(){
        //TODO Requerimiento: Consulta todos los equipos
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipo> obtenerEquipoPorId(@PathVariable Long id){
        //TODO Requerimiento: Consulta de un equipo por ID
        return null;
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Equipo>> buscarEquiposPorNombre(@RequestParam String nombre){
        //TODO Requerimiento: Busqueda de equipos por nombre
        return null;
    }

    @PostMapping
    public ResponseEntity<Equipo> crearEquipo(@RequestBody Equipo nuevoEquipo){
        //TODO Requerimiento: Creacion de un equipo
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipo> actualizarInformacionDeEquipoPorId(@PathVariable Long id){
        //TODO Requerimiento: Actualizar de Informacion de un equipo por ID
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEquipoPorId(@PathVariable Long id){
        //TODO Requerimiento: Actualizar de Informacion de un equipo por ID
        return null;
    }
}

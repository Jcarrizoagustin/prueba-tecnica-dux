package com.duxsoftware.prueba_tecnica.controllers;

import com.duxsoftware.prueba_tecnica.model.Equipo;
import com.duxsoftware.prueba_tecnica.services.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
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
        return ResponseEntity.ok(this.equipoService.todosLosEquipos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipo> obtenerEquipoPorId(@PathVariable Long id){
        return ResponseEntity.ok(this.equipoService.buscarEquipoPorId(id));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Equipo>> buscarEquiposPorNombre(@RequestParam String nombre){
        return ResponseEntity.ok(this.equipoService.buscarEquipoPorNombre(nombre));
    }

    @PostMapping
    public ResponseEntity<Equipo> crearEquipo(@RequestBody Equipo nuevoEquipo){
        //TODO Requerimiento: Creacion de un equipo
        return ResponseEntity.status(HttpStatusCode.valueOf(201))
                .body(this.equipoService.guardarNuevoEquipo(nuevoEquipo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipo> actualizarInformacionDeEquipoPorId(@PathVariable Long id){
        //TODO Requerimiento: Actualizar de Informacion de un equipo por ID
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarEquipoPorId(@PathVariable Long id){
        //TODO Requerimiento: Eliminacion un equipo por ID
        this.equipoService.eliminarEquipoPorId(id);
        return ResponseEntity.noContent().build();
    }
}

package com.duxsoftware.prueba_tecnica.services;

import ch.qos.logback.core.util.StringUtil;
import com.duxsoftware.prueba_tecnica.model.Equipo;
import com.duxsoftware.prueba_tecnica.repositories.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    public List<Equipo> todosLosEquipos(){
        return this.equipoRepository.findAll();
    }

    public Equipo buscarEquipoPorId(Long id){
        Optional<Equipo> equipoOpt = this.equipoRepository.findById(id);
        if(equipoOpt.isPresent())
            return equipoOpt.get();
        else
            throw new RuntimeException("Equipo con id: " + id + " inexistente");//TODO refactorizar manejo de errores para cumplir con el requerimiento
    }

    public List<Equipo> buscarEquipoPorNombre(String nombre){
        return this.equipoRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public Equipo guardarNuevoEquipo(Equipo equipo){
        //TODO agregar validacion para no persistir un equipo que ya este en BD
        return this.equipoRepository.save(equipo);
    }

    public void eliminarEquipoPorId(Long id){
        if(this.equipoRepository.existsById(id))
            this.equipoRepository.deleteById(id);
        else
            //TODO refactorizar manejo de errores para cumplir con el requerimiento
            throw new RuntimeException("No existe el equipo con ID: " + id);
    }
}

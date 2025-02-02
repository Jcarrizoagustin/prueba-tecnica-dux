package com.duxsoftware.prueba_tecnica.factories;

import com.duxsoftware.prueba_tecnica.dtos.EquipoDTO;
import com.duxsoftware.prueba_tecnica.model.Equipo;

public class EquipoFactory {

    public static Equipo crearEquipo(EquipoDTO equipoDTO){
        Equipo nuevoEquipo = new Equipo();
        nuevoEquipo.setNombre(equipoDTO.getNombre());
        nuevoEquipo.setLiga(equipoDTO.getLiga());
        nuevoEquipo.setPais(equipoDTO.getPais());
        return nuevoEquipo;
    }
}

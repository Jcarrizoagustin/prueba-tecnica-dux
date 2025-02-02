package com.duxsoftware.prueba_tecnica.mappers;

import com.duxsoftware.prueba_tecnica.dtos.EquipoUpdateDTO;
import com.duxsoftware.prueba_tecnica.model.Equipo;

public class EquipoMapper {

    public static Equipo actualizarDatosEquipoUpdateDTOToEquipo(Equipo equipo, EquipoUpdateDTO equipoUpdateDTO){
        equipo.setNombre(equipoUpdateDTO.getNombre());
        equipo.setLiga(equipoUpdateDTO.getLiga());
        equipo.setPais(equipoUpdateDTO.getPais());
        return equipo;
    }
}

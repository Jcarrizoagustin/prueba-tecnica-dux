package com.duxsoftware.prueba_tecnica.mappers;

import com.duxsoftware.prueba_tecnica.dtos.EquipoDTO;
import com.duxsoftware.prueba_tecnica.model.Equipo;

public class EquipoMapper {

    public static Equipo actualizarDatosEquipoUpdateDTOToEquipo(Equipo equipo, EquipoDTO equipoDTO){
        equipo.setNombre(equipoDTO.getNombre());
        equipo.setLiga(equipoDTO.getLiga());
        equipo.setPais(equipoDTO.getPais());
        return equipo;
    }
}

package com.duxsoftware.prueba_tecnica.services;

import com.duxsoftware.prueba_tecnica.model.Equipo;
import com.duxsoftware.prueba_tecnica.repositories.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    public List<Equipo> todosLosEquipos(){
        return this.equipoRepository.findAll();
    }


}

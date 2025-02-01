package com.duxsoftware.prueba_tecnica.repositories;

import com.duxsoftware.prueba_tecnica.model.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo,Long> {
}

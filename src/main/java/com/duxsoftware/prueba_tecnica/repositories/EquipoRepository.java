package com.duxsoftware.prueba_tecnica.repositories;

import com.duxsoftware.prueba_tecnica.model.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo,Long> {

    List<Equipo> findByNombreContainingIgnoreCase(String nombre);
    boolean existsByNombreIgnoreCaseAndLigaIgnoreCaseAndPaisIgnoreCase(String nombre, String liga, String pais);
}

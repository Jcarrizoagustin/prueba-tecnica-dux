package com.duxsoftware.prueba_tecnica.repositories;

import com.duxsoftware.prueba_tecnica.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByUsername(String username);
}

package com.duxsoftware.prueba_tecnica.utils;

import com.duxsoftware.prueba_tecnica.model.Usuario;
import com.duxsoftware.prueba_tecnica.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DefaultUserLoaderUtil implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (userRepository.findByUsername("test").isEmpty()) {
            Usuario admin = new Usuario();
            admin.setUsername("test");
            admin.setPassword(passwordEncoder.encode("12345"));
            userRepository.save(admin);
        }
    }
}

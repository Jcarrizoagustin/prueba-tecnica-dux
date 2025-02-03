package com.duxsoftware.prueba_tecnica.services;

import com.duxsoftware.prueba_tecnica.dtos.LoginRequestDTO;
import com.duxsoftware.prueba_tecnica.repositories.UserRepository;
import com.duxsoftware.prueba_tecnica.security.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;

    public Token login(LoginRequestDTO loginRequestDTO) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(),loginRequestDTO.getPassword()));
        UserDetails user = userRepository.findByUsername(loginRequestDTO.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        return new Token(token);
    }
}

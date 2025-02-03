package com.duxsoftware.prueba_tecnica.controllers;

import com.duxsoftware.prueba_tecnica.dtos.LoginRequestDTO;
import com.duxsoftware.prueba_tecnica.security.Token;
import com.duxsoftware.prueba_tecnica.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<Token> auth(@RequestBody LoginRequestDTO loginRequestDTO){
        return ResponseEntity.ok(this.authService.login(loginRequestDTO));
    }

}

package com.duxsoftware.prueba_tecnica.security;

public class Token {

    private String token;

    public Token(String token){
        this.token = token;
    }

    public void setToken(String token){
        this.token = token;
    }

    public String getToken(){
        return this.token;
    }
}

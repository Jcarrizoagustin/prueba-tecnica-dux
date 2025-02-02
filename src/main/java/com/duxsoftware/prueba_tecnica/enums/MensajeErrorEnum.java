package com.duxsoftware.prueba_tecnica.enums;

public enum MensajeErrorEnum {

    EQUIPO_NO_ENCONTRADO("Equipo no encontrado"),
    SOLICITUD_INVALIDA("La solicitud es invalida");

    private String mensaje;
    private MensajeErrorEnum(String mensaje){
        this.mensaje = mensaje;
    }

    public String getMensaje(){
        return this.mensaje;
    }
}

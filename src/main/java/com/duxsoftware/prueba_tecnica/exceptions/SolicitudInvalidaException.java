package com.duxsoftware.prueba_tecnica.exceptions;

import com.duxsoftware.prueba_tecnica.enums.MensajeErrorEnum;

public class SolicitudInvalidaException extends RuntimeException{

    public SolicitudInvalidaException(MensajeErrorEnum mensaje){
        super(mensaje.getMensaje());
    }
}

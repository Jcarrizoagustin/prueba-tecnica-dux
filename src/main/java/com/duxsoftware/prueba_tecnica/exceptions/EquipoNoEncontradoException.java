package com.duxsoftware.prueba_tecnica.exceptions;

import com.duxsoftware.prueba_tecnica.enums.MensajeErrorEnum;

public class EquipoNoEncontradoException extends RuntimeException{

    public EquipoNoEncontradoException(MensajeErrorEnum mensajeError){
        super(mensajeError.getMensaje());
    }
}

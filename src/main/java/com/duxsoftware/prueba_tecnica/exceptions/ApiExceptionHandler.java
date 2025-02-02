package com.duxsoftware.prueba_tecnica.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(
            EquipoNoEncontradoException.class
    )
    public MensajeError notFoundError(HttpServletRequest request, Exception exception){
        return new MensajeError(exception.getMessage(), HttpStatus.NOT_FOUND.value());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(
            SolicitudInvalidaException.class
    )
    public MensajeError badRequestError(HttpServletRequest request, Exception exception){
        return new MensajeError(exception.getMessage(), HttpStatus.BAD_REQUEST.value());
    }
}

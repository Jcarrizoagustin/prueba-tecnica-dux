package com.duxsoftware.prueba_tecnica.exceptions;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ApiResponse(responseCode = "404", description = "Not Found",
            content = @Content(examples = @ExampleObject(value = """
            {
              "mensaje": "Equipo no encontrado",
              "codigo": 404
            }
        """)))
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(
            EquipoNoEncontradoException.class
    )
    public MensajeError notFoundError(HttpServletRequest request, Exception exception){
        return new MensajeError(exception.getMessage(), HttpStatus.NOT_FOUND.value());
    }

    @ApiResponse(responseCode = "404", description = "Bad Request",
            content = @Content(examples = @ExampleObject(value = """
            {
              "mensaje": "La solicitud es invalida",
              "codigo": 400
            }
        """)))
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(
            SolicitudInvalidaException.class
    )
    public MensajeError badRequestError(HttpServletRequest request, Exception exception){
        return new MensajeError(exception.getMessage(), HttpStatus.BAD_REQUEST.value());
    }

    @ApiResponse(responseCode = "500", description = "Internal Server Error",
            content = @Content(examples = @ExampleObject(value = """
            {
              "mensaje": "Error en el servidor",
              "codigo": 500
            }
        """)))
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(
            Exception.class
    )
    public MensajeError internarServerError(HttpServletRequest request, Exception exception){
        return new MensajeError(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}

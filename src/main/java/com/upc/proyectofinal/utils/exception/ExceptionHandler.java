package com.upc.proyectofinal.utils.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {ValidacionRequestException.class})
    public ResponseEntity<ErrorMessage> errorBadFormatoRequest(ValidacionRequestException ex) {
        ErrorMessage message = new ErrorMessage(
                1,
                ex.getMessage(),
                ex.getDescripcion());

        return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value ={HttpMessageNotReadableException.class})
    public ResponseEntity<ErrorMessage> errorFormatoRequest(HttpMessageNotReadableException ex) {
        ErrorMessage message = new ErrorMessage(
                2,
                "Todos los campos deben ser numéricos",
                ex.getMessage());

        return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
    }



    @org.springframework.web.bind.annotation.ExceptionHandler(value = {ValoresConfiguracionExcepcion.class})
    public ResponseEntity<?> valoresConfiguracionExcepcion(ValoresConfiguracionExcepcion e){
        ErrorMessage message = new ErrorMessage(
                -2,
                e.getMessage(),
                e.getDescripcion());

        return new ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value ={ConnectionException.class})
    public ResponseEntity<ErrorMessage> errorConnection(ConnectionException ex) {
        ErrorMessage message = new ErrorMessage(
                -1,
                ex.getMessage(),
                ex.getDescripcion());

        return new ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value ={GenericException.class})
    public ResponseEntity<ErrorMessage> errorGeneric(GenericException ex) {
        ErrorMessage message = new ErrorMessage(
                3,
                ex.getMessage(),
                ex.getDescripcion());

        return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value ={MethodArgumentTypeMismatchException.class})
    public ResponseEntity<ErrorMessage> errorFormatoRequestPath(MethodArgumentTypeMismatchException ex) {
        ErrorMessage message = new ErrorMessage(
                5,
                "Formato de dato ingresado incorrecto",
                ex.getMessage());

        return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value ={MissingServletRequestParameterException.class})
    public ResponseEntity<ErrorMessage> errorRequestParam(MissingServletRequestParameterException ex) {
        ErrorMessage message = new ErrorMessage(
                4,
                "Faltan datos para procesar la consulta",
                ex.getMessage());

        return new ResponseEntity<ErrorMessage>(message, HttpStatus.BAD_REQUEST);
    }
}

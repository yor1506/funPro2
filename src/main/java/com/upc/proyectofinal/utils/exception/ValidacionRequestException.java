package com.upc.proyectofinal.utils.exception;

public class ValidacionRequestException extends RuntimeException{

    private String message;

    private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ValidacionRequestException(String message, String descripcion){
        super();
        this.message=message;
        this.descripcion=descripcion;
    }
}

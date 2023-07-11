package com.upc.proyectofinal.utils.exception;

public class ValoresConfiguracionExcepcion extends RuntimeException{

    private String message;

    private String descripcion;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ValoresConfiguracionExcepcion(String message, String descripcion){
        super();
        this.descripcion=descripcion;
        this.message=message;
    }
}

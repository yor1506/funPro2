package com.upc.proyectofinal.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class Cliente extends Persona{
    @NotBlank(message = "No debe ser nulo ni vacío")
    @Email(message = "Se debe de colocar un correo válido")
    private String correoPersonal;
    @NotBlank(message = "No debe ser nulo ni vacío")
    @Length(max = 9,min = 9,message = "Debe tener 9 dígitos")
    private String celularPersonal;

    public String getCorreoPersonal() {
        return correoPersonal;
    }

    public void setCorreoPersonal(String correoPersonal) {
        this.correoPersonal = correoPersonal;
    }

    public String getCelularPersonal() {
        return celularPersonal;
    }

    public void setCelularPersonal(String celularPersonal) {
        this.celularPersonal = celularPersonal;
    }
}

package com.upc.proyectofinal.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class Trabajador extends Persona{
    @NotBlank(message = "No debe ser nulo ni vacío")
    @Email(message = "Se debe de colocar un correo válido")
    private String correoCorporativo;
    @NotBlank(message = "No debe ser nulo ni vacío")
    @Length(max = 9,min = 9,message = "Debe tener 9 dígitos")
    private String celularCorporativo;
    @NotNull(message = "No debe ser nulo")
    private Integer sucursalId;
    @NotBlank(message = "No debe ser nulo ni vacío")
    private String rol;

    public String getCorreoCorporativo() {
        return correoCorporativo;
    }

    public void setCorreoCorporativo(String correoCorporativo) {
        this.correoCorporativo = correoCorporativo;
    }

    public String getCelularCorporativo() {
        return celularCorporativo;
    }

    public void setCelularCorporativo(String celularCorporativo) {
        this.celularCorporativo = celularCorporativo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Integer getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(Integer sucursalId) {
        this.sucursalId = sucursalId;
    }
}

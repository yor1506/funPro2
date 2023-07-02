package com.upc.proyectofinal.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Date;

public class Persona {

    private Integer personaId;
    @NotBlank(message = "No debe ser nulo ni vacío")
    @Pattern(regexp = "^(DNI|CE)$" , message = "tipo no permitido")
    private String tipoDocumento;
    @NotBlank(message = "No debe ser nulo ni vacío")
    private String numDocumento;
    @NotBlank(message = "No debe ser nulo ni vacío")
    private String nombre;
    @NotBlank(message = "No debe ser nulo ni vacío")
    private String apellidoPaterno;
    @NotBlank(message = "No debe ser nulo ni vacío")
    private String apellidoMaterno;
    @NotNull(message = "No debe ser nulo ni vacío")
    private Date fechaNacimiento;

    private String tipoPersona;


    public Integer getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Integer personaId) {
        this.personaId = personaId;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }


}

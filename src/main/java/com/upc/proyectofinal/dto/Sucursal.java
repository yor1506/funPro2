package com.upc.proyectofinal.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class Sucursal {


    private Integer sucursalId;
    @NotBlank(message = "No debe ser nulo ni vacío")
    private String nombreSucursal;
    @NotBlank(message = "No debe ser nulo ni vacío")
    @Pattern(regexp = "^(ACTIVO|INACTIVO)$" , message = "estado no permitido")
    private String estado;
    @NotBlank(message = "No debe ser nulo ni vacío")
    private String departamento;
    @NotBlank(message = "No debe ser nulo ni vacío")
    private String provincia;
    @NotBlank(message = "No debe ser nulo ni vacío")
    private String distrito;
    @NotBlank(message = "No debe ser nulo ni vacío")
    private String direccionFiscal;
    @Email(message = "Debe tener formato de correo")
    @NotBlank(message = "No debe ser nulo ni vacío")
    private String correo;
    @NotBlank(message = "No debe ser nulo ni vacío")
    private String telefono;

    private String tipo;

    public Integer getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(Integer sucursalId) {
        this.sucursalId = sucursalId;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDireccionFiscal() {
        return direccionFiscal;
    }

    public void setDireccionFiscal(String direccionFiscal) {
        this.direccionFiscal = direccionFiscal;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

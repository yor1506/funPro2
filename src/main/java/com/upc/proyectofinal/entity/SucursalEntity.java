package com.upc.proyectofinal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Sucursal")
public class SucursalEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "sucursalid")
    private Integer id;

    @Column(name = "nombresucursal")
    private String nombreSucursal;

    @Column(name = "estado")
    private String estado;

    @Column(name = "departamento")
    private String departamento;

    @Column(name = "provincia")
    private String provincia;

    @Column(name = "distrito")
    private String distrito;

    @Column(name = "direccionfiscal")
    private String direccionFiscal;

    @Column(name = "correo")
    private String correo;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "maxcantvehiculos")
    private Integer maxCantVehiculos;

    @Column(name = "cantvendedores")
    private Integer cantVendedores;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getMaxCantVehiculos() {
        return maxCantVehiculos;
    }

    public void setMaxCantVehiculos(Integer maxCantVehiculos) {
        this.maxCantVehiculos = maxCantVehiculos;
    }

    public Integer getCantVendedores() {
        return cantVendedores;
    }

    public void setCantVendedores(Integer cantVendedores) {
        this.cantVendedores = cantVendedores;
    }
}

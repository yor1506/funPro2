package com.upc.proyectofinal.entity;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "Persona")
public class PersonaEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "personaid")
    private Integer id;

    @Column(name = "tipodocumento")
    private String tipoDocumento;

    @Column(name = "numdocumento" , unique = true)
    private String numDocumento;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidopaterno")
    private String apellidoPaterno;

    @Column(name = "apellidomaterno")
    private String apellidoMaterno;

    @Column(name = "fechanacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Column(name = "tipopersona")
    private String tipoPersona;

    @Column(name = "correopersonal")
    private String correoPersonal;

    @Column(name = "correocorporativo")
    private String correoCorporativo;

    @Column(name = "rol")
    private String rol;

    @Column(name = "celularpersonal")
    private String celularPersonal;

    @Column(name = "celularcorporativo")
    private String celularCorporativo;

    @Column(name = "sucursalid")
    private Integer sucursalId;



    public String getCelularPersonal() {
        return celularPersonal;
    }

    public void setCelularPersonal(String celularPersonal) {
        this.celularPersonal = celularPersonal;
    }

    public String getCelularCorporativo() {
        return celularCorporativo;
    }

    public void setCelularCorporativo(String celularCorporativo) {
        this.celularCorporativo = celularCorporativo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCorreoPersonal() {
        return correoPersonal;
    }

    public void setCorreoPersonal(String correoPersonal) {
        this.correoPersonal = correoPersonal;
    }

    public String getCorreoCorporativo() {
        return correoCorporativo;
    }

    public void setCorreoCorporativo(String correoCorporativo) {
        this.correoCorporativo = correoCorporativo;
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

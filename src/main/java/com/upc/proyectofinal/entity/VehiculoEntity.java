package com.upc.proyectofinal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Vehiculo")
public class VehiculoEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "vehiculoid")
    private Integer id;


    @Column(name = "placa" , unique = true)
    private String placa;

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "version")
    private String version;

    @Column(name = "color")
    private String color;

    @Column(name = "kilometraje")
    private Double kilometraje;

    @Column(name = "aniovehiculo")
    private Integer anioVehiculo;

    @Column(name = "aireacondicionado")
    private Boolean aireAcondicionado;

    @Column(name = "transmision")
    private String transmision;

    @Column(name = "preciovehiculonuevo")
    private Double precioVehiculoNuevo;

    @Column(name = "precioreferencial")
    private Double precioReferencial;

    @Column(name = "preciofinal")
    private Double preciofinal;

    @Column(name = "estado")
    private String estado; //Ingresado,Cotizado

    @Column(name = "clienteid")
    private Integer clienteId;

    @Column(name = "compradorid")
    private Integer compradorId;

    @Column(name = "combustible")
    private String combustible;

    @Column(name = "revisiontecnica")
    private Boolean revisionTecnica;

    @Column(name = "revisionadministrativa")
    private Boolean revisionAdministrativa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(Double kilometraje) {
        this.kilometraje = kilometraje;
    }

    public Integer getAnioVehiculo() {
        return anioVehiculo;
    }

    public void setAnioVehiculo(Integer anioVehiculo) {
        this.anioVehiculo = anioVehiculo;
    }

    public Boolean getAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(Boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    public Double getPrecioVehiculoNuevo() {
        return precioVehiculoNuevo;
    }

    public void setPrecioVehiculoNuevo(Double precioVehiculoNuevo) {
        this.precioVehiculoNuevo = precioVehiculoNuevo;
    }

    public Double getPrecioReferencial() {
        return precioReferencial;
    }

    public void setPrecioReferencial(Double precioReferencial) {
        this.precioReferencial = precioReferencial;
    }

    public Double getPreciofinal() {
        return preciofinal;
    }

    public void setPreciofinal(Double preciofinal) {
        this.preciofinal = preciofinal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public Integer getCompradorId() {
        return compradorId;
    }

    public void setCompradorId(Integer compradorId) {
        this.compradorId = compradorId;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public Boolean getRevisionTecnica() {
        return revisionTecnica;
    }

    public void setRevisionTecnica(Boolean revisionTecnica) {
        this.revisionTecnica = revisionTecnica;
    }

    public Boolean getRevisionAdministrativa() {
        return revisionAdministrativa;
    }

    public void setRevisionAdministrativa(Boolean revisionAdministrativa) {
        this.revisionAdministrativa = revisionAdministrativa;
    }
}

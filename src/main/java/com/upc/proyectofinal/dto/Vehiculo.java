package com.upc.proyectofinal.dto;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

public class Vehiculo {

    private Integer vehiculoId;

    @Length(max = 6 , min = 6, message = "Debe tener 6 caracteres")
    @NotBlank(message = "No debe ser nulo ni vacío")
    private String placa;
    @NotBlank(message = "No debe ser nulo ni vacío")
    private String marca;
    @NotBlank(message = "No debe ser nulo ni vacío")
    private String modelo;
    @NotBlank(message = "No debe ser nulo ni vacío")
    private String version;
    @NotBlank(message = "No debe ser nulo ni vacío")
    private String color;

    @Max(value = 100000 , message = "El máximo de kilometraje permitido es 10k")
    private Double kilometraje;
    @NotNull(message = "No debe ser nulo")
    @Min(value = 2013 , message = "No debe tener más de 10 años de antiguedad")
    private Integer anioVehiculo;
    @NotNull(message = "No debe ser nulo")
    private Boolean aireAcondicionado;
    @Pattern(regexp = "^(MECANICO|AUTOMATICO)$" , message = "transmision no permitida")
    private String transmision;
    @Min(value = 10000 , message = "Debe ser mayor a 10k dolares")
    private Double precioVehiculoNuevo;
    @Min(value = 5000 , message = "Debe ser mayor a 5k dolares")
    private Double precioReferencial;
    @Min(value = 5000 , message = "Debe ser mayor a 5k dolares")
    private Double preciofinal;

    private String estado;
    @NotNull(message = "debe enviar el id de cliente")
    private Integer clienteId;
    @NotNull(message = "debe enviar el id de comprador")
    private Integer compradorId;
    @Pattern(regexp = "^(GNV|GLP)$" , message = "combustible no permitido")
    private String combustible;

    private Boolean revisionTecnica;

    private Boolean revisionAdministrativa;

    public Integer getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(Integer vehiculoId) {
        this.vehiculoId = vehiculoId;
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

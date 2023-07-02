package com.upc.proyectofinal.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class Tienda extends Sucursal{
    @Min(value = 5 , message = "La cantidad mínima es 5")
    @NotNull(message = "No debe ser nulo")
    private Integer cantVendedores;

    public Integer getCantVendedores() {
        return cantVendedores;
    }

    public void setCantVendedores(Integer cantVendedores) {
        this.cantVendedores = cantVendedores;
    }
}

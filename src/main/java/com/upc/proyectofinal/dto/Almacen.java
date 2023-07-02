package com.upc.proyectofinal.dto;

import jakarta.validation.constraints.Min;

public class Almacen extends Sucursal{

    @Min(value = 15, message = "Debe tener 15 vehiculos como mínimo")
    private Integer maxCantVehiculos;

    public Integer getMaxCantVehiculos() {
        return maxCantVehiculos;
    }

    public void setMaxCantVehiculos(Integer maxCantVehiculos) {
        this.maxCantVehiculos = maxCantVehiculos;
    }
}

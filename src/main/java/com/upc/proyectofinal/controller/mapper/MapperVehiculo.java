package com.upc.proyectofinal.controller.mapper;

import com.upc.proyectofinal.dto.Vehiculo;
import com.upc.proyectofinal.entity.VehiculoEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperVehiculo {


    public List<Vehiculo> listEntityToListDTOVehiculo(List<VehiculoEntity> listaEntidadVehiculo) {
        List<Vehiculo> listaVehiculo = new ArrayList<>();
        listaEntidadVehiculo.forEach(x->{
            listaVehiculo.add(entityToDtoVehiculo(x));
        });
        return listaVehiculo;
    }

    public Vehiculo entityToDtoVehiculo(VehiculoEntity x) {
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setVehiculoId(x.getId());
        vehiculo.setPlaca(x.getPlaca());
        vehiculo.setMarca(x.getMarca());
        vehiculo.setModelo(x.getModelo());
        vehiculo.setVersion(x.getVersion());
        vehiculo.setColor(x.getColor());
        vehiculo.setKilometraje(x.getKilometraje());
        vehiculo.setCombustible(x.getCombustible());
        vehiculo.setAnioVehiculo(x.getAnioVehiculo());
        vehiculo.setAireAcondicionado(x.getAireAcondicionado());
        vehiculo.setTransmision(x.getTransmision());
        vehiculo.setPreciofinal(x.getPreciofinal());
        vehiculo.setPrecioReferencial(x.getPrecioReferencial());
        vehiculo.setPrecioVehiculoNuevo(x.getPrecioVehiculoNuevo());
        vehiculo.setEstado(x.getEstado());
        vehiculo.setClienteId(x.getClienteId());
        vehiculo.setCompradorId(x.getCompradorId());
        vehiculo.setRevisionTecnica(x.getRevisionTecnica());
        vehiculo.setRevisionAdministrativa(x.getRevisionAdministrativa());
        return vehiculo;
    }

    public VehiculoEntity dtoVehiculoToEntity(Vehiculo x) {
        VehiculoEntity vehiculo = new VehiculoEntity();
        vehiculo.setId(x.getVehiculoId());
        vehiculo.setPlaca(x.getPlaca());
        vehiculo.setMarca(x.getMarca());
        vehiculo.setModelo(x.getModelo());
        vehiculo.setVersion(x.getVersion());
        vehiculo.setColor(x.getColor());
        vehiculo.setKilometraje(x.getKilometraje());
        vehiculo.setCombustible(x.getCombustible());
        vehiculo.setAnioVehiculo(x.getAnioVehiculo());
        vehiculo.setAireAcondicionado(x.getAireAcondicionado());
        vehiculo.setTransmision(x.getTransmision());
        vehiculo.setPreciofinal(x.getPreciofinal());
        vehiculo.setPrecioReferencial(x.getPrecioReferencial());
        vehiculo.setPrecioVehiculoNuevo(x.getPrecioVehiculoNuevo());
        vehiculo.setEstado(x.getEstado());
        vehiculo.setClienteId(x.getClienteId());
        vehiculo.setCompradorId(x.getCompradorId());
        vehiculo.setRevisionTecnica(x.getRevisionTecnica());
        vehiculo.setRevisionAdministrativa(x.getRevisionAdministrativa());
        return vehiculo;
    }
}

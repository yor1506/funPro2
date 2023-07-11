package com.upc.proyectofinal.controller.mapper;

import com.upc.proyectofinal.dto.Almacen;
import com.upc.proyectofinal.dto.Sucursal;
import com.upc.proyectofinal.dto.Tienda;
import com.upc.proyectofinal.entity.SucursalEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperSucursal {
    public List<Sucursal> listSucursalEntityToListSucursalDTO(List<SucursalEntity> listaSucursalEntity) {
        List<Sucursal> listaSucursal = new ArrayList<>();
        listaSucursalEntity.forEach(x->{
            listaSucursal.add(sucursalEntityToSucursalDTO(x));
        });
        return listaSucursal;
    }

    public Sucursal sucursalEntityToSucursalDTO(SucursalEntity x) {
        if (x.getTipo().equalsIgnoreCase("TIENDA")){
            return sucursalEntityToTienda(x);

        }else {
            return sucursalEntityToAlmacen(x);
        }
    }

    public Almacen sucursalEntityToAlmacen(SucursalEntity x) {
        Almacen almacen = new Almacen();
        almacen.setSucursalId(x.getId());
        almacen.setNombreSucursal(x.getNombreSucursal());
        almacen.setDepartamento(x.getDepartamento());
        almacen.setEstado(x.getEstado());
        almacen.setProvincia(x.getProvincia());
        almacen.setDistrito(x.getDistrito());
        almacen.setDireccionFiscal(x.getDireccionFiscal());
        almacen.setCorreo(x.getCorreo());
        almacen.setTelefono(x.getTelefono());
        almacen.setTipo(x.getTipo());
        almacen.setMaxCantVehiculos(x.getMaxCantVehiculos());
        return almacen;

    }

    public Tienda sucursalEntityToTienda(SucursalEntity x) {
        Tienda tienda = new Tienda();
        tienda.setSucursalId(x.getId());
        tienda.setNombreSucursal(x.getNombreSucursal());
        tienda.setDepartamento(x.getDepartamento());
        tienda.setEstado(x.getEstado());
        tienda.setProvincia(x.getProvincia());
        tienda.setDistrito(x.getDistrito());
        tienda.setDireccionFiscal(x.getDireccionFiscal());
        tienda.setCorreo(x.getCorreo());
        tienda.setTelefono(x.getTelefono());
        tienda.setTipo(x.getTipo());
        tienda.setCantVendedores(x.getCantVendedores());
        return tienda;
    }

    public SucursalEntity tiendaToSucursal(Tienda x) {
        SucursalEntity sucursal = new SucursalEntity();
        sucursal.setId(x.getSucursalId());
        sucursal.setNombreSucursal(x.getNombreSucursal());
        sucursal.setDepartamento(x.getDepartamento());
        sucursal.setEstado(x.getEstado());
        sucursal.setProvincia(x.getProvincia());
        sucursal.setDistrito(x.getDistrito());
        sucursal.setDireccionFiscal(x.getDireccionFiscal());
        sucursal.setCorreo(x.getCorreo());
        sucursal.setTelefono(x.getTelefono());
        sucursal.setTipo(x.getTipo());
        sucursal.setCantVendedores(x.getCantVendedores());
        return sucursal;
    }

    public SucursalEntity almacenToSucursal(Almacen x) {
        SucursalEntity sucursal = new SucursalEntity();
        sucursal.setId(x.getSucursalId());
        sucursal.setNombreSucursal(x.getNombreSucursal());
        sucursal.setDepartamento(x.getDepartamento());
        sucursal.setEstado(x.getEstado());
        sucursal.setProvincia(x.getProvincia());
        sucursal.setDistrito(x.getDistrito());
        sucursal.setDireccionFiscal(x.getDireccionFiscal());
        sucursal.setCorreo(x.getCorreo());
        sucursal.setTelefono(x.getTelefono());
        sucursal.setTipo(x.getTipo());
        sucursal.setCantVendedores(x.getMaxCantVehiculos());
        return sucursal;
    }


    public List<Almacen> listSucursalEntityToListAlmacen(List<SucursalEntity> listaSucursalEntity) {
        List<Almacen> listaAlmacen = new ArrayList<>();
        listaSucursalEntity.forEach(x->{
            if (x.getTipo().equalsIgnoreCase("ALMACEN"))
                listaAlmacen.add(sucursalEntityToAlmacen(x));
        });
        return listaAlmacen;
    }

    public List<Tienda> listSucursalEntityToListTienda(List<SucursalEntity> listaSucursalEntity) {
        List<Tienda> listaTienda = new ArrayList<>();
        listaSucursalEntity.forEach(x->{
            if (x.getTipo().equalsIgnoreCase("TIENDA"))
                listaTienda.add(sucursalEntityToTienda(x));
        });
        return listaTienda;
    }
}

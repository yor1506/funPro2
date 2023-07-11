package com.upc.proyectofinal.service;

import com.upc.proyectofinal.entity.SucursalEntity;
import com.upc.proyectofinal.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalService {

    @Autowired
    SucursalRepository sucursalRepository;

    public List<SucursalEntity> listarSucursal(){
        return sucursalRepository.findAll();
    }

    public Optional<SucursalEntity> buscarSucursal(Integer sucursalId){
        Optional<SucursalEntity>  sucursal = sucursalRepository.findById(sucursalId);
        return sucursal;
    }

    public SucursalEntity guardarSucursal(SucursalEntity se){
        SucursalEntity sucursal = sucursalRepository.save(se);
        return sucursal;
    }
}

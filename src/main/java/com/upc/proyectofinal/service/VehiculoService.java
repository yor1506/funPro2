package com.upc.proyectofinal.service;

import com.upc.proyectofinal.entity.PersonaEntity;
import com.upc.proyectofinal.entity.VehiculoEntity;
import com.upc.proyectofinal.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoService {

    @Autowired
    VehiculoRepository vehiculoRepository;

    public List<VehiculoEntity> listarVehiculos(){
        return vehiculoRepository.findAll();
    }

    public VehiculoEntity guardarVehiculo(VehiculoEntity ve){
        VehiculoEntity vehiculo = vehiculoRepository.save(ve);
        return vehiculo;
    }

    public Optional<VehiculoEntity> obtenerVehiculo(Integer id){
        Optional<VehiculoEntity>  vehiculo = vehiculoRepository.findById(id);
        return vehiculo;
    }
}

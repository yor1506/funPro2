package com.upc.proyectofinal.controller;

import com.upc.proyectofinal.dto.Vehiculo;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface IVehiculoController {

    ResponseEntity<?> listarVehiculos();

    ResponseEntity<?> guardar(Vehiculo vehiculo, BindingResult result);

    ResponseEntity<?> editar(Vehiculo vehiculo, BindingResult result);

    ResponseEntity<?> obtener(Integer id);

    ResponseEntity<?> checkVerificacionTecnica(Integer id);

    ResponseEntity<?> checkVerificacionAdministrativa(Integer id);



}

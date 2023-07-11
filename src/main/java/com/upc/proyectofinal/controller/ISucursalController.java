package com.upc.proyectofinal.controller;

import com.upc.proyectofinal.dto.Almacen;
import com.upc.proyectofinal.dto.Cliente;
import com.upc.proyectofinal.dto.Tienda;
import com.upc.proyectofinal.dto.Trabajador;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;


public interface ISucursalController {

    ResponseEntity<?> listarSucursal();

    ResponseEntity<?> guardarAlmacen(Almacen almacen, BindingResult result);

    ResponseEntity<?> guardarTienda(Tienda tienda, BindingResult result);

    ResponseEntity<?> listarAlmacen();

    ResponseEntity<?> listarTienda();

    ResponseEntity<?> obtenerSucursal(Integer id);

    ResponseEntity<?> editarAlmacen(Almacen almacen,BindingResult result);

    ResponseEntity<?> editarTienda(Tienda tienda,BindingResult result);
}

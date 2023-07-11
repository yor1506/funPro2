package com.upc.proyectofinal.controller;

import com.upc.proyectofinal.dto.Cliente;
import com.upc.proyectofinal.dto.Trabajador;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface IPersonaController {

    ResponseEntity<?> listarPersonas();

    ResponseEntity<?> guardarTrabajador(Trabajador trabajador, BindingResult result);

    ResponseEntity<?> guardarCliente(Cliente cliente,BindingResult result);

    ResponseEntity<?> listarClientes();

    ResponseEntity<?> listarTrabajadores();

    ResponseEntity<?> obtenerPersona(Integer id);

    ResponseEntity<?> eliminarPersona(Integer id);

    ResponseEntity<?> editarCliente(Cliente cliente,BindingResult result);

    ResponseEntity<?> editarTrabajador(Trabajador trabajador,BindingResult result);
}

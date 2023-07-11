package com.upc.proyectofinal.controller.impl;

import com.upc.proyectofinal.controller.IVehiculoController;
import com.upc.proyectofinal.controller.mapper.MapperVehiculo;
import com.upc.proyectofinal.dto.Vehiculo;
import com.upc.proyectofinal.entity.PersonaEntity;
import com.upc.proyectofinal.entity.VehiculoEntity;
import com.upc.proyectofinal.service.PersonaService;
import com.upc.proyectofinal.service.VehiculoService;
import com.upc.proyectofinal.utils.exception.GenericException;
import com.upc.proyectofinal.utils.exception.ValidacionRequestException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController implements IVehiculoController {

    @Autowired
    VehiculoService vehiculoService;

    @Autowired
    MapperVehiculo mapperVehiculo;

    @Autowired
    PersonaService personaService;


    @Override
    @GetMapping("/listar")
    public ResponseEntity<?> listarVehiculos() {
        List<VehiculoEntity> listaEntidadVehiculo = vehiculoService.listarVehiculos();
        List<Vehiculo> listaVehiculoResponse = mapperVehiculo.listEntityToListDTOVehiculo(listaEntidadVehiculo);
        return ResponseEntity.ok(listaVehiculoResponse);
    }

    @Override
    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@Valid @RequestBody Vehiculo vehiculo, BindingResult result) {
        if (result.hasErrors()){
           HashMap<String,String> erorres = new HashMap<>();
           result.getFieldErrors().forEach(e->{
               erorres.put(e.getField(),e.getDefaultMessage());
           });
            throw new ValidacionRequestException("Datos de entrada incorrectos",erorres.toString());
        }
        if (!Objects.isNull(vehiculo.getVehiculoId())){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("error","no se debe enviar ID para guardar vehiculo");
            throw new ValidacionRequestException("Datos de entrada incorrectos",erorres.toString());
        }
        Optional<PersonaEntity> persona = personaService.obtenerPersona(vehiculo.getClienteId());
        if (persona.isEmpty()||!persona.get().getTipoPersona().equalsIgnoreCase("CLIENTE")){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("clienteId","no es un cliente");
            throw new ValidacionRequestException("Datos de entrada incorrectos",erorres.toString());
        }
        persona = personaService.obtenerPersona(vehiculo.getCompradorId());
        if (persona.isEmpty()||!persona.get().getTipoPersona().equalsIgnoreCase("TRABAJADOR")){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("trabajadorId","no es un trabajador");
            throw new ValidacionRequestException("Datos de entrada incorrectos",erorres.toString());
        }
        vehiculo.setRevisionAdministrativa(false);
        vehiculo.setRevisionTecnica(false);
        vehiculo.setEstado("COTIZADO");
        VehiculoEntity vehiculoEntity = mapperVehiculo.dtoVehiculoToEntity(vehiculo);
        vehiculoEntity = vehiculoService.guardarVehiculo(vehiculoEntity);
        if (Objects.isNull(vehiculoEntity)){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("error","no se pudo guardar vehiculo");
            throw new GenericException("Error de sistema",erorres.toString());
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @Override
    @PostMapping("/editar")
    public ResponseEntity<?> editar(@Valid @RequestBody Vehiculo vehiculo, BindingResult result) {
        if (result.hasErrors()){
            HashMap<String,String> erorres = new HashMap<>();
            result.getFieldErrors().forEach(e->{
                erorres.put(e.getField(),e.getDefaultMessage());
            });
            throw new ValidacionRequestException("Datos de entrada incorrectos",erorres.toString());
        }
        if (Objects.isNull(vehiculo.getVehiculoId())){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("error","se debe enviar ID para editar vehiculo");
            throw new ValidacionRequestException("Datos de entrada incorrectos",erorres.toString());
        }
        Optional<PersonaEntity> persona = personaService.obtenerPersona(vehiculo.getClienteId());
        if (persona.isEmpty()||!persona.get().getTipoPersona().equalsIgnoreCase("CLIENTE")){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("clienteId","no es un cliente");
            throw new ValidacionRequestException("Datos de entrada incorrectos",erorres.toString());
        }
        persona = personaService.obtenerPersona(vehiculo.getCompradorId());
        if (persona.isEmpty()||!persona.get().getTipoPersona().equalsIgnoreCase("TRABAJADOR")){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("trabajadorId","no es un trabajador");
            throw new ValidacionRequestException("Datos de entrada incorrectos",erorres.toString());
        }
        vehiculo.setRevisionAdministrativa(false);
        vehiculo.setRevisionTecnica(false);
        vehiculo.setEstado("COTIZADO");
        VehiculoEntity vehiculoEntity = mapperVehiculo.dtoVehiculoToEntity(vehiculo);
        vehiculoEntity = vehiculoService.guardarVehiculo(vehiculoEntity);
        if (Objects.isNull(vehiculoEntity)){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("error","no se pudo guardar vehiculo");
            throw new GenericException("Error de sistema",erorres.toString());
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    @GetMapping("/obtener/{id}")
    public ResponseEntity<?> obtener(@PathVariable Integer id) {
        Optional<VehiculoEntity> vehiculo = vehiculoService.obtenerVehiculo(id);
        if (vehiculo.isEmpty()){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("error","no se encuentra vehiculo");
            throw new ValidacionRequestException("Datos de entrada incorrectos",erorres.toString());
        }
        Vehiculo response = mapperVehiculo.entityToDtoVehiculo(vehiculo.get());
        return ResponseEntity.ok(response);
    }

    @Override
    @PostMapping("/check/tecnico/{id}")
    public ResponseEntity<?> checkVerificacionTecnica(@PathVariable Integer id) {
        Optional<VehiculoEntity> vehiculo = vehiculoService.obtenerVehiculo(id);
        if (vehiculo.isEmpty()){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("error","no se encuentra vehiculo");
            throw new ValidacionRequestException("Datos de entrada incorrectos",erorres.toString());
        }
        VehiculoEntity estado = vehiculo.get();
        estado.setRevisionTecnica(Boolean.TRUE);
        estado = vehiculoService.guardarVehiculo(estado);
        if (Objects.isNull(estado)){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("error","no se pudo actualizar estado de verificacion tecnica");
            throw new GenericException("Error de sistema",erorres.toString());
        }
        return ResponseEntity.ok(estado);
    }

    @Override
    @PostMapping("/check/administrativo/{id}")
    public ResponseEntity<?> checkVerificacionAdministrativa(@PathVariable Integer id) {
        Optional<VehiculoEntity> vehiculo = vehiculoService.obtenerVehiculo(id);
        if (vehiculo.isEmpty()){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("error","no se encuentra vehiculo");
            throw new ValidacionRequestException("Datos de entrada incorrectos",erorres.toString());
        }
        VehiculoEntity estado = vehiculo.get();
        estado.setRevisionAdministrativa(Boolean.TRUE);
        estado = vehiculoService.guardarVehiculo(estado);
        if (Objects.isNull(estado)){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("error","no se pudo actualizar estado de verificacion administrativa");
            throw new GenericException("Error de sistema",erorres.toString());
        }
        return ResponseEntity.ok(estado);
    }
}

package com.upc.proyectofinal.controller.impl;

import com.upc.proyectofinal.controller.IPersonaController;
import com.upc.proyectofinal.controller.mapper.MapperPersona;
import com.upc.proyectofinal.dto.Cliente;
import com.upc.proyectofinal.dto.Persona;
import com.upc.proyectofinal.dto.Trabajador;
import com.upc.proyectofinal.entity.PersonaEntity;
import com.upc.proyectofinal.entity.SucursalEntity;
import com.upc.proyectofinal.service.PersonaService;
import com.upc.proyectofinal.service.SucursalService;
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
@RequestMapping("/persona")
public class PersonaController implements IPersonaController {

    @Autowired
    PersonaService personaService;

    @Autowired
    SucursalService sucursalService;

    @Autowired
    MapperPersona mapperPersona;




    @Override
    @GetMapping("/listar")
    public ResponseEntity<?> listarPersonas() {
        List<PersonaEntity> listaPersonasEntity = personaService.listarPersonas();
        List<Persona> listaPersonas = mapperPersona.listEntityToListDTOPersona(listaPersonasEntity);
        return ResponseEntity.ok(listaPersonas);
    }

    @Override
    @PostMapping("/trabajador/guardar")
    public ResponseEntity<?> guardarTrabajador(@Valid @RequestBody Trabajador trabajador, BindingResult result) {
        if (result.hasErrors()){
            HashMap<String,String> erorres = new HashMap<>();
            result.getFieldErrors().forEach(e->{
                erorres.put(e.getField(),e.getDefaultMessage());
            });
            throw new ValidacionRequestException("Datos de entrada incorrectos",erorres.toString());
        }
        if (!Objects.isNull(trabajador.getPersonaId())){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("error","no se debe enviar ID para guardar trabajador");
            throw new ValidacionRequestException("Datos de entrada incorrectos",erorres.toString());
        }
        Optional<SucursalEntity>  sucursalEntity = sucursalService.buscarSucursal(trabajador.getSucursalId());
        if (sucursalEntity.isEmpty()){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("sucursalId","no existe");
            throw new ValidacionRequestException("Datos de entrada incorrectos",erorres.toString());
        }
        trabajador.setTipoPersona("TRABAJADOR");
        PersonaEntity personaEntity = mapperPersona.trabajadorToPersonaEntity(trabajador);
        personaEntity = personaService.guardarPersona(personaEntity);
        if (Objects.isNull(personaEntity)){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("error","no se pudo guardar trabajador");
            throw new GenericException("Error genérico de servicio",erorres.toString());
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    @PostMapping("/cliente/guardar")
    public ResponseEntity<?> guardarCliente(@Valid @RequestBody Cliente cliente, BindingResult result) {
        if (result.hasErrors()){
            HashMap<String,String> erorres = new HashMap<>();
            result.getFieldErrors().forEach(e->{
                erorres.put(e.getField(),e.getDefaultMessage());
            });
            throw new ValidacionRequestException("Datos de entrada incorrectos",erorres.toString());
        }
        if (!Objects.isNull(cliente.getPersonaId())){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("error","no se debe enviar ID para guardar cliente");
            throw new ValidacionRequestException("Datos de entrada incorrectos",erorres.toString());
        }
        cliente.setTipoPersona("CLIENTE");
        PersonaEntity personaEntity = mapperPersona.clienteToPersonaEntity(cliente);
        personaEntity = personaService.guardarPersona(personaEntity);
        if (Objects.isNull(personaEntity)){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("error","no se pudo guardar trabajador");
            throw new GenericException("Error de servicio",erorres.toString());
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    @GetMapping("/listar/clientes")
    public ResponseEntity<?> listarClientes() {
        List<PersonaEntity> listaPersonasEntity = personaService.listarPersonas();
        List<Persona> listaClientes = mapperPersona.listEntityToListDTOClientes(listaPersonasEntity);
        return ResponseEntity.ok(listaClientes);
    }

    @Override
    @GetMapping("/listar/trabajadores")
    public ResponseEntity<?> listarTrabajadores() {
        List<PersonaEntity> listaPersonasEntity = personaService.listarPersonas();
        List<Persona> listaTrabajadores = mapperPersona.listEntityToListDTOTrabajador(listaPersonasEntity);
        return ResponseEntity.ok(listaTrabajadores);
    }

    @Override
    @GetMapping("/obtener/{id}")
    public ResponseEntity<?> obtenerPersona(@PathVariable Integer id) {
        Optional<PersonaEntity> persona = personaService.obtenerPersona(id);
        if (persona.isEmpty()){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("error","no se encuentra persona");
            throw new ValidacionRequestException("Datos de entrada incorrectos",erorres.toString());
        }
        Persona response = new Persona();
        if (persona.get().getTipoPersona().equalsIgnoreCase("CLIENTE"))
            response = mapperPersona.personaEntityToCliente(persona.get());

        if (persona.get().getTipoPersona().equalsIgnoreCase("TRABAJADOR"))
            response = mapperPersona.personaEntityToTrabajador(persona.get());

        return ResponseEntity.ok(response);
    }

    @Override
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarPersona(@PathVariable Integer id) {
        Optional<PersonaEntity> persona = personaService.obtenerPersona(id);
        if (persona.isEmpty()){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("error","no se encuentra persona");
            throw new ValidacionRequestException("Datos de entrada incorrectos",erorres.toString());
        }
        personaService.eliminarPersona(id);
        return ResponseEntity.ok().build();
    }

    @Override
    @PostMapping("/cliente/editar")
    public ResponseEntity<?> editarCliente(@Valid @RequestBody Cliente cliente, BindingResult result) {
        if (result.hasErrors()){
            HashMap<String,String> erorres = new HashMap<>();
            result.getFieldErrors().forEach(e->{
                erorres.put(e.getField(),e.getDefaultMessage());
            });
            throw new ValidacionRequestException("Datos de entrada incorrectos",erorres.toString());
        }
        if (Objects.isNull(cliente.getPersonaId())){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("error","se debe indicar el ID del cliente a editar");
            throw new ValidacionRequestException("Datos de entrada incorrectos",erorres.toString());
        }
        Optional<PersonaEntity>  validacion = personaService.obtenerPersona(cliente.getPersonaId());
        if (validacion.isEmpty()){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("error","cliente a editar no existe");
            throw new ValidacionRequestException("Datos de entrada incorrectos",erorres.toString());
        }
        if (!validacion.get().getTipoPersona().equalsIgnoreCase("CLIENTE")){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("error","no es un cliente");
            throw new ValidacionRequestException("Datos de entrada incorrectos",erorres.toString());
        }
        cliente.setTipoPersona("CLIENTE");
        PersonaEntity personaEntity = mapperPersona.clienteToPersonaEntity(cliente);
        personaEntity = personaService.guardarPersona(personaEntity);
        if (Objects.isNull(personaEntity)){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("error","no se pudo editar cliente");
            throw new GenericException("Error de servicio",erorres.toString());
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    @PostMapping("/trabajador/editar")
    public ResponseEntity<?> editarTrabajador(@Valid @RequestBody Trabajador trabajador, BindingResult result) {
        if (result.hasErrors()){
            HashMap<String,String> erorres = new HashMap<>();
            result.getFieldErrors().forEach(e->{
                erorres.put(e.getField(),e.getDefaultMessage());
            });
            throw new ValidacionRequestException("Datos de entrada incorrectos",erorres.toString());
        }
        if (Objects.isNull(trabajador.getPersonaId())){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("error","se debe indicar el ID del trabajador a editar");
            throw new ValidacionRequestException("Datos de entrada incorrectos",erorres.toString());
        }
        Optional<PersonaEntity>  validacion = personaService.obtenerPersona(trabajador.getPersonaId());
        if (validacion.isEmpty()){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("error","trabajador a editar no existe");
            throw new ValidacionRequestException("Datos de entrada incorrectos",erorres.toString());
        }
        if (!validacion.get().getTipoPersona().equalsIgnoreCase("TRABAJADOR")){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("error","no es un trabajador");
            throw new ValidacionRequestException("Datos de entrada incorrectos",erorres.toString());
        }
        Optional<SucursalEntity>  sucursalEntity = sucursalService.buscarSucursal(trabajador.getSucursalId());
        if (sucursalEntity.isEmpty()){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("sucursalId","no existe");
            throw new ValidacionRequestException("Datos de entrada incorrectos",erorres.toString());
        }
        trabajador.setTipoPersona("TRABAJADOR");
        PersonaEntity personaEntity = mapperPersona.trabajadorToPersonaEntity(trabajador);
        personaEntity = personaService.guardarPersona(personaEntity);
        if (Objects.isNull(personaEntity)){
            HashMap<String,String> erorres = new HashMap<>();
            erorres.put("error","no se pudo editar trabajador");
            throw new GenericException("Error de servicio",erorres.toString());
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

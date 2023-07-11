package com.upc.proyectofinal.controller.mapper;

import com.upc.proyectofinal.dto.Cliente;
import com.upc.proyectofinal.dto.Persona;
import com.upc.proyectofinal.dto.Trabajador;
import com.upc.proyectofinal.entity.PersonaEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapperPersona {

    public Cliente personaEntityToCliente(PersonaEntity personaEntity){
           Cliente cliente = new Cliente();
           cliente.setPersonaId(personaEntity.getId());
           cliente.setNumDocumento(personaEntity.getNumDocumento());
           cliente.setTipoDocumento(personaEntity.getTipoDocumento());
           cliente.setNombre(personaEntity.getNombre());
           cliente.setApellidoPaterno(personaEntity.getApellidoPaterno());
           cliente.setApellidoMaterno(personaEntity.getApellidoMaterno());
           cliente.setFechaNacimiento(personaEntity.getFechaNacimiento());
           cliente.setTipoPersona(personaEntity.getTipoPersona());
           cliente.setCorreoPersonal(personaEntity.getCorreoPersonal());
           cliente.setCelularPersonal(personaEntity.getCelularPersonal());
           return cliente;
    }

    public Trabajador personaEntityToTrabajador(PersonaEntity personaEntity){
        Trabajador trabajador = new Trabajador();
        trabajador.setPersonaId(personaEntity.getId());
        trabajador.setNumDocumento(personaEntity.getNumDocumento());
        trabajador.setTipoDocumento(personaEntity.getTipoDocumento());
        trabajador.setNombre(personaEntity.getNombre());
        trabajador.setApellidoPaterno(personaEntity.getApellidoPaterno());
        trabajador.setApellidoMaterno(personaEntity.getApellidoMaterno());
        trabajador.setFechaNacimiento(personaEntity.getFechaNacimiento());
        trabajador.setTipoPersona(personaEntity.getTipoPersona());
        trabajador.setCorreoCorporativo(personaEntity.getCorreoCorporativo());
        trabajador.setCelularCorporativo(personaEntity.getCelularCorporativo());
        trabajador.setRol(personaEntity.getRol());
        trabajador.setSucursalId(personaEntity.getSucursalId());
        return trabajador;
    }

    public List<Persona> listEntityToListDTOPersona(List<PersonaEntity> listaPersonasEntity) {
        List<Persona> listaPersonas = new ArrayList<>();
        listaPersonasEntity.forEach(x->{
            listaPersonas.add(personasEntityToTipoPersona(x));
        });
        return listaPersonas;
    }

    private Persona personasEntityToTipoPersona(PersonaEntity x) {
        if (x.getTipoPersona().equalsIgnoreCase("CLIENTE")){
            return personaEntityToCliente(x);

        }else {
            return personaEntityToTrabajador(x);
        }
    }

    public PersonaEntity trabajadorToPersonaEntity(Trabajador trabajador) {
        PersonaEntity personaEntity = new PersonaEntity();
        personaEntity.setId(trabajador.getPersonaId());
        personaEntity.setNumDocumento(trabajador.getNumDocumento());
        personaEntity.setTipoDocumento(trabajador.getTipoDocumento());
        personaEntity.setNombre(trabajador.getNombre());
        personaEntity.setApellidoPaterno(trabajador.getApellidoPaterno());
        personaEntity.setApellidoMaterno(trabajador.getApellidoMaterno());
        personaEntity.setFechaNacimiento(trabajador.getFechaNacimiento());
        personaEntity.setTipoPersona(trabajador.getTipoPersona());
        personaEntity.setCorreoCorporativo(trabajador.getCorreoCorporativo());
        personaEntity.setCelularCorporativo(trabajador.getCelularCorporativo());
        personaEntity.setRol(trabajador.getRol());
        personaEntity.setSucursalId(trabajador.getSucursalId());
        return personaEntity;
    }

    public PersonaEntity clienteToPersonaEntity(Cliente cliente) {
        PersonaEntity personaEntity = new PersonaEntity();
        personaEntity.setId(cliente.getPersonaId());
        personaEntity.setNumDocumento(cliente.getNumDocumento());
        personaEntity.setTipoDocumento(cliente.getTipoDocumento());
        personaEntity.setNombre(cliente.getNombre());
        personaEntity.setApellidoPaterno(cliente.getApellidoPaterno());
        personaEntity.setApellidoMaterno(cliente.getApellidoMaterno());
        personaEntity.setFechaNacimiento(cliente.getFechaNacimiento());
        personaEntity.setTipoPersona(cliente.getTipoPersona());
        personaEntity.setCorreoPersonal(cliente.getCorreoPersonal());
        personaEntity.setCelularPersonal(cliente.getCelularPersonal());
        return personaEntity;
    }

    public List<Persona> listEntityToListDTOClientes(List<PersonaEntity> listaPersonasEntity) {
        List<Persona> listaPersonas = new ArrayList<>();
        listaPersonasEntity.forEach(x->{
            if (x.getTipoPersona().equalsIgnoreCase("CLIENTE"))
                 listaPersonas.add(personaEntityToCliente(x));
        });
        return listaPersonas;
    }

    public List<Persona> listEntityToListDTOTrabajador(List<PersonaEntity> listaPersonasEntity) {
        List<Persona> listaPersonas = new ArrayList<>();
        listaPersonasEntity.forEach(x->{
            if (x.getTipoPersona().equalsIgnoreCase("TRABAJADOR"))
                listaPersonas.add(personaEntityToTrabajador(x));
        });
        return listaPersonas;
    }
}

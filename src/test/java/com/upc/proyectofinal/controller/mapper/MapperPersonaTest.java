package com.upc.proyectofinal.controller.mapper;

import com.upc.proyectofinal.dto.Cliente;
import com.upc.proyectofinal.dto.Trabajador;
import com.upc.proyectofinal.entity.PersonaEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapperPersonaTest {

    private MapperPersona mapperPersona = new MapperPersona();

    private Generador generador = Generador.getInstance();


    @Test
    void  personaEntityToCliente(){
        PersonaEntity pe = generador.generarPersonaEntityCliente();
        Cliente cliente = mapperPersona.personaEntityToCliente(pe);
        assertEquals(pe.getId(),cliente.getPersonaId());
        assertEquals(pe.getNombre(),cliente.getNombre());
        assertEquals(pe.getApellidoMaterno(),cliente.getApellidoMaterno());
        assertEquals(pe.getApellidoPaterno(),cliente.getApellidoPaterno());
        assertEquals(pe.getTipoPersona(),cliente.getTipoPersona());
        assertEquals(pe.getTipoDocumento(),cliente.getTipoDocumento());
        assertEquals(pe.getFechaNacimiento(),cliente.getFechaNacimiento());
        assertEquals(pe.getCorreoPersonal(),cliente.getCorreoPersonal());
        assertEquals(pe.getCelularPersonal(),cliente.getCelularPersonal());

    }

    @Test
    void personaEntityToTrabajador(){
        PersonaEntity pe = generador.generarPersonaEntityTrabajador();
        Trabajador trabajador = mapperPersona.personaEntityToTrabajador(pe);
        assertEquals(pe.getId(),trabajador.getPersonaId());
        assertEquals(pe.getNombre(),trabajador.getNombre());
        assertEquals(pe.getApellidoMaterno(),trabajador.getApellidoMaterno());
        assertEquals(pe.getApellidoPaterno(),trabajador.getApellidoPaterno());
        assertEquals(pe.getTipoPersona(),trabajador.getTipoPersona());
        assertEquals(pe.getTipoDocumento(),trabajador.getTipoDocumento());
        assertEquals(pe.getFechaNacimiento(),trabajador.getFechaNacimiento());
        assertEquals(pe.getCorreoCorporativo(),trabajador.getCorreoCorporativo());
        assertEquals(pe.getCelularCorporativo(),trabajador.getCelularCorporativo());
        assertEquals(pe.getRol(),trabajador.getRol());

    }



    @Test
    void trabajadorToPersonaEntity(){
        Trabajador tr = generador.generarTrabajador();
        PersonaEntity personaEntity = mapperPersona.trabajadorToPersonaEntity(tr);
        assertEquals(personaEntity.getId(),tr.getPersonaId());
        assertEquals(personaEntity.getNombre(),tr.getNombre());
        assertEquals(personaEntity.getApellidoMaterno(),tr.getApellidoMaterno());
        assertEquals(personaEntity.getApellidoPaterno(),tr.getApellidoPaterno());
        assertEquals(personaEntity.getTipoPersona(),tr.getTipoPersona());
        assertEquals(personaEntity.getTipoDocumento(),tr.getTipoDocumento());
        assertEquals(personaEntity.getFechaNacimiento(),tr.getFechaNacimiento());
        assertEquals(personaEntity.getCorreoCorporativo(),tr.getCorreoCorporativo());
        assertEquals(personaEntity.getCelularCorporativo(),tr.getCelularCorporativo());
        assertEquals(personaEntity.getRol(),tr.getRol());

    }

    @Test
    void clienteToPersonaEntity(){
        Cliente cl = generador.generarCliente();
        PersonaEntity personaEntity = mapperPersona.clienteToPersonaEntity(cl);
        assertEquals(personaEntity.getId(),cl.getPersonaId());
        assertEquals(personaEntity.getNombre(),cl.getNombre());
        assertEquals(personaEntity.getApellidoMaterno(),cl.getApellidoMaterno());
        assertEquals(personaEntity.getApellidoPaterno(),cl.getApellidoPaterno());
        assertEquals(personaEntity.getTipoPersona(),cl.getTipoPersona());
        assertEquals(personaEntity.getTipoDocumento(),cl.getTipoDocumento());
        assertEquals(personaEntity.getFechaNacimiento(),cl.getFechaNacimiento());
        assertEquals(personaEntity.getCorreoPersonal(),cl.getCorreoPersonal());
        assertEquals(personaEntity.getCelularPersonal(),cl.getCelularPersonal());

    }
    

}
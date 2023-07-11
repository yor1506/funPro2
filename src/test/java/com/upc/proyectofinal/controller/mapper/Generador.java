package com.upc.proyectofinal.controller.mapper;

import com.upc.proyectofinal.dto.Cliente;
import com.upc.proyectofinal.dto.Trabajador;
import com.upc.proyectofinal.entity.PersonaEntity;

import java.util.Date;

public class Generador {

    private static Generador instance;
    private Generador() {}
    public static Generador getInstance() {
        if (instance == null) {
            instance = new Generador();
        }
        return instance;
    }

    public PersonaEntity generarPersonaEntityCliente(){
        PersonaEntity personaEntity = new PersonaEntity();
        personaEntity.setId(1);
        personaEntity.setNumDocumento("76190857");
        personaEntity.setTipoDocumento("DNI");
        personaEntity.setNombre("Jose");
        personaEntity.setApellidoPaterno("Rivera");
        personaEntity.setApellidoMaterno("Contreras");
        Date date = new Date();
        personaEntity.setFechaNacimiento(date);
        personaEntity.setTipoPersona("Cliente");
        personaEntity.setCorreoPersonal("correoprueba@gmail.com");
        personaEntity.setCelularPersonal("990990990");
        return personaEntity;
    }

    public PersonaEntity generarPersonaEntityTrabajador(){
        PersonaEntity personaEntity = new PersonaEntity();
        personaEntity.setId(1);
        personaEntity.setNumDocumento("76190857");
        personaEntity.setTipoDocumento("DNI");
        personaEntity.setNombre("Jose");
        personaEntity.setApellidoPaterno("Rivera");
        personaEntity.setApellidoMaterno("Contreras");
        Date date = new Date();
        personaEntity.setFechaNacimiento(date);
        personaEntity.setTipoPersona("Trabajador");
        personaEntity.setCorreoCorporativo("correoprueba@gmail.com");
        personaEntity.setCelularCorporativo("990990990");
        personaEntity.setRol("Vendedor");
        return personaEntity;
    }

    public Trabajador generarTrabajador(){
        Trabajador trabajador = new Trabajador();
        trabajador.setPersonaId(1);
        trabajador.setNumDocumento("76190857");
        trabajador.setTipoDocumento("DNI");
        trabajador.setNombre("Jose");
        trabajador.setApellidoPaterno("Rivera");
        trabajador.setApellidoMaterno("Contreras");
        Date date = new Date();
        trabajador.setFechaNacimiento(date);
        trabajador.setTipoPersona("Trabajador");
        trabajador.setCorreoCorporativo("correoprueba@gmail.com");
        trabajador.setCelularCorporativo("990990990");
        trabajador.setRol("Vendedor");
        return trabajador;
    }

    public Cliente generarCliente(){
        Cliente cliente = new Cliente();
        cliente.setPersonaId(1);
        cliente.setNumDocumento("76190857");
        cliente.setTipoDocumento("DNI");
        cliente.setNombre("Jose");
        cliente.setApellidoPaterno("Rivera");
        cliente.setApellidoMaterno("Contreras");
        Date date = new Date();
        cliente.setFechaNacimiento(date);
        cliente.setTipoPersona("Cliente");
        cliente.setCorreoPersonal("correoprueba@gmail.com");
        cliente.setCelularPersonal("990990990");
        return cliente;
    }



}

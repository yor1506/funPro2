package com.upc.proyectofinal.service;

import com.upc.proyectofinal.entity.PersonaEntity;
import com.upc.proyectofinal.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    public List<PersonaEntity> listarPersonas(){
        return personaRepository.findAll();
    }

    public PersonaEntity guardarPersona(PersonaEntity pe){
        PersonaEntity persona = personaRepository.save(pe);
        return persona;
    }

    public Optional<PersonaEntity> obtenerPersona(Integer id){
        Optional<PersonaEntity>  persona = personaRepository.findById(id);
        return persona;
    }

    public void eliminarPersona(Integer id){
        personaRepository.deleteById(id);
    }
}

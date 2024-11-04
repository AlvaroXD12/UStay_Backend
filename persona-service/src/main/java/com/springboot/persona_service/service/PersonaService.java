package com.springboot.persona_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.persona_service.entity.Persona;
import com.springboot.persona_service.repository.PersonaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PersonaService {
	@Autowired
	PersonaRepository personaRepository;
	
	public List<Persona> findAll() {
		return personaRepository.findAll();
	}
	
	public void save(Persona persona) {
		personaRepository.save(persona);
	}
	
	public Optional<Persona> findById(int id) {
		return personaRepository.findById(id);
	}
	
	public void delete(int id) {
		personaRepository.deleteById(id);
	}
	
	public boolean existsById(int id) {
		return personaRepository.existsById(id);
	}
	
	public void update(int id, Persona updatedPersona) {
		Optional<Persona> optionalPersona = personaRepository.findById(id);
		if (optionalPersona.isPresent()) {
			Persona persona = optionalPersona.get();
			persona.setNombre(updatedPersona.getNombre());
			persona.setApellido(updatedPersona.getApellido());
			persona.setCorreo(updatedPersona.getCorreo());
			persona.setTelefono(updatedPersona.getTelefono());
			persona.setFechaRegistro(updatedPersona.getFechaRegistro());
			personaRepository.save(persona);
		}
	}
}

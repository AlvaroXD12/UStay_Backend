package com.springboot.persona_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.persona_service.entity.Persona;


public interface PersonaRepository extends JpaRepository<Persona, Integer> {

}
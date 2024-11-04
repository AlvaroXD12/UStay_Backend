package com.springboot.edificio_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.edificio_service.entity.Edificio;

public interface EdificioRepository extends JpaRepository<Edificio, Integer> {

}
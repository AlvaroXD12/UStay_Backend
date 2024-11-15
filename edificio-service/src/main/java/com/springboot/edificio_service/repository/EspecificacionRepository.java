package com.springboot.edificio_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.edificio_service.entity.Especificaciones;

@Repository
public interface EspecificacionRepository extends JpaRepository<Especificaciones, Integer>{

}

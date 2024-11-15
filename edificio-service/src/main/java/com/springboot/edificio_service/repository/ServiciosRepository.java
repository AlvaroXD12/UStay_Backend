package com.springboot.edificio_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.edificio_service.entity.Servicios;

@Repository
public interface ServiciosRepository extends JpaRepository<Servicios, Integer>{

    @Query(value = "SELECT s.* FROM servicios s JOIN inmueble i ON s.inmueble_id = i.id WHERE i.id = :inmuebleId", nativeQuery = true)
	List<Servicios> findByInmuebleId(@Param("inmuebleId") int inmuebleId);
}

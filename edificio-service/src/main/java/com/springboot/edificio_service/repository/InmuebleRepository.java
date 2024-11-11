package com.springboot.edificio_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.edificio_service.entity.Inmueble;

public interface InmuebleRepository extends JpaRepository<Inmueble, Integer>{

	@Query(value = "SELECT * FROM inmueble WHERE disponibilidad=1", nativeQuery = true)
	List<Inmueble> findAllByAvailability();
	
}

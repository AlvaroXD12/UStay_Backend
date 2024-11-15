package com.springboot.edificio_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.edificio_service.entity.Inmueble;
import com.springboot.edificio_service.entity.Servicios;
import com.springboot.edificio_service.service.ServiciosService;

@RestController
@RequestMapping("/servicios")
public class ServicioController {

	@Autowired
	private ServiciosService serviciosService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Servicios>> listar(){
		List<Servicios> list = serviciosService.listar();
		if (list.isEmpty()) {
			return new ResponseEntity<>(org.springframework.http.HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, org.springframework.http.HttpStatus.OK);
	}
	
	@GetMapping("/inmueble/{inmuebleId}")
    public List<Servicios> getServiciosByInmueble(@PathVariable int inmuebleId) {
        return serviciosService.listByInmueble(inmuebleId);
    }
}

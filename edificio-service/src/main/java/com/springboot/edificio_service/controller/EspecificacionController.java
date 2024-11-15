package com.springboot.edificio_service.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.edificio_service.entity.Especificaciones;
import com.springboot.edificio_service.service.EspecificacionService;

@RestController
@RequestMapping("/especificacion")
public class EspecificacionController {

	@Autowired
	private EspecificacionService especificacionService;

	@GetMapping("/listar")
	public ResponseEntity<List<Especificaciones>> listar() {
		List<Especificaciones> list = especificacionService.listar();
		if (list.isEmpty()) {
			return new ResponseEntity<>(org.springframework.http.HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(list, org.springframework.http.HttpStatus.OK);
	}
}

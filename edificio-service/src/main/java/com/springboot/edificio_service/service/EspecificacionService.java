package com.springboot.edificio_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.edificio_service.entity.Especificaciones;
import com.springboot.edificio_service.repository.EspecificacionRepository;

@Service
public class EspecificacionService {

	@Autowired
	private EspecificacionRepository especificacionRepository;

	public List<Especificaciones> listar() {
		return especificacionRepository.findAll();
	}

}

package com.springboot.edificio_service.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.edificio_service.entity.Servicios;
import com.springboot.edificio_service.repository.ServiciosRepository;

@Service
public class ServiciosService {

	@Autowired
	private ServiciosRepository serviciosRepository;
	
	public List<Servicios> listar(){
		return serviciosRepository.findAll();
	}
	
	public List<Servicios> listByInmueble(int inmuebleId){
        return serviciosRepository.findByInmuebleId(inmuebleId);
	}
	
}

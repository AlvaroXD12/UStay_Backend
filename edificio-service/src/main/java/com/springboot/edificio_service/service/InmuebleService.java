package com.springboot.edificio_service.service;

import java.util.List;
import java.util.Optional;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.edificio_service.entity.Inmueble;
import com.springboot.edificio_service.repository.InmuebleRepository;

import jakarta.transaction.Transactional;

@org.springframework.stereotype.Service
public class InmuebleService {

    @Autowired
    private InmuebleRepository inmuebleRepository;

    public List<Inmueble> listar() {
        return inmuebleRepository.findAll();
    }
    
    public List<Inmueble> listar_disponibilidad(){
    	return inmuebleRepository.findAllByAvailability();
    }
    
    public Optional<Inmueble> findById(int id) {
        return inmuebleRepository.findById(id);
    }

    public void save(Inmueble inmueble){
        inmuebleRepository.save(inmueble);
    }

    public void delete(int id){
        inmuebleRepository.deleteById(id);
    }

    public boolean existsById(int id){
        return inmuebleRepository.existsById(id);   
    }

    public void update(int id, Inmueble updateInmueble){
        Optional<Inmueble> optionalInmueble= inmuebleRepository.findById(id);
        if (optionalInmueble.isPresent()) {
            Inmueble inmueble = optionalInmueble.get();
            inmueble.setDescripcion(updateInmueble.getDescripcion());
            inmueble.setDisponibilidad(updateInmueble.isDisponibilidad());
            inmueble.setPrecio(updateInmueble.getPrecio());
            inmueble.setEdificio(updateInmueble.getEdificio());
            inmuebleRepository.save(inmueble);
        }
    }
}

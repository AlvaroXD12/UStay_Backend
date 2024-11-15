package com.springboot.edificio_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.edificio_service.entity.Zona;
import com.springboot.edificio_service.repository.ZonaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ZonaService {
    @Autowired
    ZonaRepository zonaRepository;
    
    public List<Zona> findAll() {
        return zonaRepository.findAll();
    }
    
    public void save(Zona zona) {
        zonaRepository.save(zona);
    }
    
    public Optional<Zona> findById(int id) {
        return zonaRepository.findById(id);
    }
    
    public void delete(int id) {
        zonaRepository.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return zonaRepository.existsById(id);
    }
    
    public void update(int id, Zona updatedZona) {
        Optional<Zona> optionalZona = zonaRepository.findById(id);
        if (optionalZona.isPresent()) {
            Zona zona = optionalZona.get();
            zona.setNombreZona(updatedZona.getNombreZona());
            zonaRepository.save(zona);
        }
    }
}

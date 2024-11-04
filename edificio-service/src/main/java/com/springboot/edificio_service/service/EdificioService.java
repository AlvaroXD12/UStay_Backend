package com.springboot.edificio_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.edificio_service.entity.Edificio;
import com.springboot.edificio_service.repository.EdificioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EdificioService {
    @Autowired
    EdificioRepository edificioRepository;
    
    public List<Edificio> findAll() {
        return edificioRepository.findAll();
    }
    
    public void save(Edificio edificio) {
        edificioRepository.save(edificio);
    }
    
    public Optional<Edificio> findById(int id) {
        return edificioRepository.findById(id);
    }
    
    public void delete(int id) {
        edificioRepository.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return edificioRepository.existsById(id);
    }
    
    public void update(int id, Edificio updatedEdificio) {
        Optional<Edificio> optionalEdificio = edificioRepository.findById(id);
        if (optionalEdificio.isPresent()) {
            Edificio edificio = optionalEdificio.get();
            edificio.setReferenciaEdificio(updatedEdificio.getReferenciaEdificio());
            edificio.setDireccion(updatedEdificio.getDireccion());
            edificio.setNpisos(updatedEdificio.getNpisos());
            edificioRepository.save(edificio);
        }
    }
}

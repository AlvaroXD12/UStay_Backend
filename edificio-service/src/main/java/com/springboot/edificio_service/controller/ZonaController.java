package com.springboot.edificio_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.springboot.edificio_service.entity.Zona;
import com.springboot.edificio_service.service.ZonaService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/zona")
public class ZonaController {

    @Autowired
    private ZonaService zonaService;
    
    @GetMapping("/hola")
    public String hola(){
        return "Hola";
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Zona>> getAllZonas() {
        List<Zona> list = zonaService.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @GetMapping("/listar/{id}")
    public ResponseEntity<Zona> getZonaById(@PathVariable("id") int id) {
        Optional<Zona> zona = zonaService.findById(id);
        return zona.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Zona zona) {
        try {
            zonaService.save(zona);
            return new ResponseEntity<>("Zona Guardada", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable("id") int id, @RequestBody Zona zona) {
        try {
            if (!zonaService.existsById(id)) {
                return new ResponseEntity<>("No existe la zona", HttpStatus.NOT_FOUND);
            }
            zonaService.update(id, zona);
            return new ResponseEntity<>("Zona Actualizada", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        try {
            if (!zonaService.existsById(id)) {
                return new ResponseEntity<>("No existe la zona", HttpStatus.NOT_FOUND);
            }
            zonaService.delete(id);
            return new ResponseEntity<>("Zona eliminada", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

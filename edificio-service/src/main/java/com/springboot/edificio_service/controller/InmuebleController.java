package com.springboot.edificio_service.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.edificio_service.entity.Inmueble;
import com.springboot.edificio_service.service.InmuebleService;

@RestController
@RequestMapping("/inmueble")
public class InmuebleController {
    
    @Autowired
    private InmuebleService inmuebleService;

    @GetMapping("/hola")
    public String hola() {
    	return "Hola desde InmuebleController";
    }
    
    @GetMapping("/listar")
    public ResponseEntity<List<Inmueble>> listar(){
    	List<Inmueble> list = inmuebleService.listar_disponibilidad();
    	if (list.isEmpty()) {
            return new ResponseEntity<>(org.springframework.http.HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, org.springframework.http.HttpStatus.OK);
    }
    
    @GetMapping("/listar-todo")
    public ResponseEntity<List<Inmueble>> getAllInmuebles() {
        List<Inmueble> list = inmuebleService.listar();
        if (list.isEmpty()) {
            return new ResponseEntity<>(org.springframework.http.HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, org.springframework.http.HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Inmueble> getInmuebleById(@PathVariable("id") int id) {
        Optional<Inmueble> inmueble = inmuebleService.findById(id);
        return inmueble.map(value -> new ResponseEntity<>(value, org.springframework.http.HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(org.springframework.http.HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Inmueble inmueble) {
        try {
            inmuebleService.save(inmueble);
            return new ResponseEntity<>("Inmueble Guardado", org.springframework.http.HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable("id") int id, @RequestBody Inmueble inmueble) {
        try {
            if (!inmuebleService.existsById(id)) {
                return new ResponseEntity<>("No existe el inmueble", org.springframework.http.HttpStatus.NOT_FOUND);
            }
            inmuebleService.update(id, inmueble);
            return new ResponseEntity<>("Inmueble Actualizado", org.springframework.http.HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        try {
            if (!inmuebleService.existsById(id)) {
                return new ResponseEntity<>("No existe el inmueble", org.springframework.http.HttpStatus.NOT_FOUND);
            }
            inmuebleService.delete(id);
            return new ResponseEntity<>("Inmueble eliminado", org.springframework.http.HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

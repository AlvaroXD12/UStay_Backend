package com.springboot.edificio_service.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
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

import com.springboot.edificio_service.entity.Edificio;
import com.springboot.edificio_service.service.EdificioService;

@RestController
@RequestMapping("/api/edificio")
public class EdificioController {

    @Value("${message}")
    private String message;

    @Value("${global-message}")
    private String globalMessage;
   
    @RequestMapping(method = RequestMethod.GET)
    public Map<String, String> message() {
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("message", message);
        respuesta.put("global-message", globalMessage);
        return respuesta;
    }

    @Autowired
    private EdificioService edificioService;
    
    @GetMapping("/hola")
    public String hola(){
        return "Hola";
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Edificio>> getAllEdificios() {
        List<Edificio> list = edificioService.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @GetMapping("/lista/{id}")
    public ResponseEntity<Edificio> getEdificioById(@PathVariable("id") int id) {
        Optional<Edificio> edificio = edificioService.findById(id);
        return edificio.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Edificio edificio) {
        try {
            edificioService.save(edificio);
            return new ResponseEntity<>("Edificio Guardado", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable("id") int id, @RequestBody Edificio edificio) {
        try {
            if (!edificioService.existsById(id)) {
                return new ResponseEntity<>("No existe el edificio", HttpStatus.NOT_FOUND);
            }
            edificioService.update(id, edificio);
            return new ResponseEntity<>("Edificio Actualizado", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        try {
            if (!edificioService.existsById(id)) {
                return new ResponseEntity<>("No existe el edificio", HttpStatus.NOT_FOUND);
            }
            edificioService.delete(id);
            return new ResponseEntity<>("Edificio eliminado", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

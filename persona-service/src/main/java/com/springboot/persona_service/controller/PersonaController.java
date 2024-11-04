package com.springboot.persona_service.controller;

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

import com.springboot.persona_service.entity.Persona;
import com.springboot.persona_service.service.PersonaService;

@RestController
@RequestMapping("/api/persona")
public class PersonaController {

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
    private PersonaService personaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> getAllPersonas() {
        List<Persona> list = personaService.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @GetMapping("/id/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable int id) {
        Optional<Persona> persona = personaService.findById(id);
        return persona.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Persona persona) {
        try {
            personaService.save(persona);
            return new ResponseEntity<>("Persona Guardada", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Persona persona) {
        try {
            if (!personaService.existsById(id)) {
                return new ResponseEntity<>("No existe la persona", HttpStatus.NOT_FOUND);
            }
            personaService.update(id, persona);
            return new ResponseEntity<>("Persona Actualizada", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        try {
            if (!personaService.existsById(id)) {
                return new ResponseEntity<>("No existe la persona", HttpStatus.NOT_FOUND);
            }
            personaService.delete(id);
            return new ResponseEntity<>("Persona eliminada", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

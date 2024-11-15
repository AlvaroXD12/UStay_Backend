package com.springboot.edificio_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.edificio_service.entity.Edificio;
import com.springboot.edificio_service.service.EdificioService;


@RestController
@RequestMapping("/api/edificio")
public class EdificioController {

    @Autowired
    private EdificioService edificioService;

    @GetMapping("/hola")
    public String hola() {
        return "Hola";
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Edificio>> getAllEdificios() {
        List<Edificio> list = edificioService.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Edificio> getEdificioById(@PathVariable("id") int id) {
        Optional<Edificio> edificio = edificioService.findById(id);
        return edificio.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(
            @ModelAttribute Edificio edificio,
            @RequestParam("file") MultipartFile file) {
        try {
            // Procesa y guarda el edificio y la imagen
            edificioService.save(edificio, file);
            return ResponseEntity.status(HttpStatus.CREATED).body("Edificio guardado con éxito");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar el edificio");
        }
    }

    // Método para actualizar un edificio existente junto con la imagen
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(
            @PathVariable("id") int id,
            @ModelAttribute Edificio edificio,
            @RequestParam("file") MultipartFile imagen) {
        try {
            if (!edificioService.existsById(id)) {
                return new ResponseEntity<>("No existe el edificio", HttpStatus.NOT_FOUND);
            }
            edificioService.update(id, edificio, imagen);
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

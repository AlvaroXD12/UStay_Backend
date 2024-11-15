package com.springboot.edificio_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.edificio_service.entity.Partner;
import com.springboot.edificio_service.service.PartnerService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/partner")
public class PartnerController {

	@Autowired
	private PartnerService partnerService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Partner>> listar(){
		List<Partner> list = partnerService.listar();
		if (list.isEmpty()) {
            return new ResponseEntity<>(org.springframework.http.HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list, org.springframework.http.HttpStatus.OK);
	}
	
	@PostMapping("/save")
    public ResponseEntity<?> save(
            @ModelAttribute Partner partner,
            @RequestParam("file") MultipartFile file) {
        try {
            // Procesa y guarda el edificio y la imagen
            partnerService.save(partner, file, file);
            return ResponseEntity.status(HttpStatus.CREATED).body("partnerguardado con éxito");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar el edificio");
        }
    }
	
}
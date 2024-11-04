package com.springboot.partner_service.controller;

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

import com.springboot.partner_service.entity.Partner;
import com.springboot.partner_service.service.PartnerService;

@RestController
@RequestMapping("/apipartner")
public class PartnerController {

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
    private PartnerService partnerService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Partner>> getAllPartners() {
        List<Partner> list = partnerService.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @GetMapping("/id/{id}")
    public ResponseEntity<Partner> getPartnerById(@PathVariable int id) {
        Optional<Partner> partner = partnerService.findById(id);
        return partner.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Partner partner) {
        try {
            partnerService.save(partner);
            return new ResponseEntity<>("Partner Guardado", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Partner partner) {
        try {
            if (!partnerService.existsById(id)) {
                return new ResponseEntity<>("No existe el partner", HttpStatus.NOT_FOUND);
            }
            partnerService.update(id, partner);
            return new ResponseEntity<>("Partner Actualizado", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        try {
            if (!partnerService.existsById(id)) {
                return new ResponseEntity<>("No existe el partner", HttpStatus.NOT_FOUND);
            }
            partnerService.delete(id);
            return new ResponseEntity<>("Partner eliminado", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

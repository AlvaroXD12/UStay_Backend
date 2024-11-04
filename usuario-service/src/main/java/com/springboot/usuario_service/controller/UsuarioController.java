package com.springboot.usuario_service.controller;

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

import com.springboot.usuario_service.entity.Usuario;
import com.springboot.usuario_service.service.UsuarioService;

@RestController
@RequestMapping("/apiusuario")
public class UsuarioController {

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
    private UsuarioService usuarioService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> list = usuarioService.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    
    @GetMapping("/id/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable int id) {
        Optional<Usuario> usuario = usuarioService.findById(id);
        return usuario.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Usuario usuario) {
        try {
            usuarioService.save(usuario);
            return new ResponseEntity<>("Usuario Guardado", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Usuario usuario) {
        try {
            if (!usuarioService.existsById(id)) {
                return new ResponseEntity<>("No existe el usuario", HttpStatus.NOT_FOUND);
            }
            usuarioService.update(id, usuario);
            return new ResponseEntity<>("Usuario Actualizado", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        try {
            if (!usuarioService.existsById(id)) {
                return new ResponseEntity<>("No existe el usuario", HttpStatus.NOT_FOUND);
            }
            usuarioService.delete(id);
            return new ResponseEntity<>("Usuario eliminado", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

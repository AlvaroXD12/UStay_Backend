package com.springboot.persona_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Reseña {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idREseña;
    private String calificacion;
    private String comentario;
    private String fechaReseña;
    private String telefono;
    private String fechaRegistro;

}

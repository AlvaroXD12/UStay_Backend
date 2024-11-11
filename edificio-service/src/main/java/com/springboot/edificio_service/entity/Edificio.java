package com.springboot.edificio_service.entity;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Edificio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String referenciaEdificio;
    private String direccion;
    private String npisos;
    private String correoEmpresa;

    @OneToMany(mappedBy = "edificio")
    @JsonIgnore
    private List<Inmueble> inmuebles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReferenciaEdificio() {
        return referenciaEdificio;
    }

    public void setReferenciaEdificio(String referenciaEdificio) {
        this.referenciaEdificio = referenciaEdificio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNpisos() {
        return npisos;
    }

    public void setNpisos(String npisos) {
        this.npisos = npisos;
    }

    public String getCorreoEmpresa() {
        return correoEmpresa;
    }

    public void setCorreoEmpresa(String correoEmpresa) {
        this.correoEmpresa = correoEmpresa;
    }
    
    public Edificio(int id, String referenciaEdificio, String direccion, String npisos, String correoEmpresa) {
        this.id = id;
        this.referenciaEdificio = referenciaEdificio;
        this.direccion = direccion;
        this.npisos = npisos;
        this.correoEmpresa = correoEmpresa;
    }

    public Edificio() {
    }
}

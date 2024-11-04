package com.springboot.partner_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Partner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPartner;
    private String nombreEmpresa;
    private String ruc;
    private String direccionEmpresa;
    private String correoEmpresa;
    public int getIdPartner() {
        return idPartner;
    }
    public void setIdPartner(int idPartner) {
        this.idPartner = idPartner;
    }
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
    public String getRuc() {
        return ruc;
    }
    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }
    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }
    public String getCorreoEmpresa() {
        return correoEmpresa;
    }
    public void setCorreoEmpresa(String correoEmpresa) {
        this.correoEmpresa = correoEmpresa;
    }
    public Partner() {
    }
    public Partner(int idPartner, String nombreEmpresa, String ruc, String direccionEmpresa, String correoEmpresa) {
        this.idPartner = idPartner;
        this.nombreEmpresa = nombreEmpresa;
        this.ruc = ruc;
        this.direccionEmpresa = direccionEmpresa;
        this.correoEmpresa = correoEmpresa;
    }
    
    

    
    
    
    
}

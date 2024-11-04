package com.springboot.edificio_service.DTO;

public class EdificioDTO {

    private int idEdificio;
    private String referenciaEdificio;
    private String direccion;
    private String npisos;
    private String correoEmpresa;
    public int getIdEdificio() {
        return idEdificio;
    }
    public void setIdEdificio(int idEdificio) {
        this.idEdificio = idEdificio;
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
    public EdificioDTO() {
    }
    public EdificioDTO(int idEdificio, String referenciaEdificio, String direccion, String npisos,
            String correoEmpresa) {
        this.idEdificio = idEdificio;
        this.referenciaEdificio = referenciaEdificio;
        this.direccion = direccion;
        this.npisos = npisos;
        this.correoEmpresa = correoEmpresa;
    }
    
    
}

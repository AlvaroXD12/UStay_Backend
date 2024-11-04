package com.springboot.usuario_service.DTO;

public class UsuarioDTO {

    private int idUsuario;
    private String user;
    private String contrasena;
    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public UsuarioDTO() {
    }
    public UsuarioDTO(int idUsuario, String user, String contrasena) {
        this.idUsuario = idUsuario;
        this.user = user;
        this.contrasena = contrasena;
    }
    
    
    

    

    
}

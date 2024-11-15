package com.springboot.edificio_service.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Partner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String direccion;
	private String correo_empresa;
	private String telefono_empresa;
	private String dni;
	private String img;
	private String img2;

	@OneToMany(mappedBy = "partner")
	@JsonIgnore
	private List<Edificio> edificio;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo_empresa() {
		return correo_empresa;
	}

	public void setCorreo_empresa(String correo_empresa) {
		this.correo_empresa = correo_empresa;
	}

	public String getTelefono_empresa() {
		return telefono_empresa;
	}

	public void setTelefono_empresa(String telefono_empresa) {
		this.telefono_empresa = telefono_empresa;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	
	
	public String getImg2() {
		return img2;
	}

	public void setImg2(String img2) {
		this.img2 = img2;
	}

	public Partner(int id, String direccion, String correo_empresa, String telefono_empresa, String dni, String img, String img2) {
		this.id = id;
		this.direccion = direccion;
		this.correo_empresa = correo_empresa;
		this.telefono_empresa = telefono_empresa;
		this.dni = dni;
		this.img = img;
		this.img2 = img2;
	}

	public Partner() {
		// TODO Auto-generated constructor stub
	}

}

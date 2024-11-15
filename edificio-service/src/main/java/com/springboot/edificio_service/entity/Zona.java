package com.springboot.edificio_service.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Zona{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombreZona;

	@OneToMany(mappedBy = "zona")
	@JsonIgnore
	private List<Edificio> edificios;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreZona() {
		return nombreZona;
	}

	public void setNombreZona(String nombreZona) {
		this.nombreZona = nombreZona;
	}

	public Zona(int id, String nombreZona) {
		this.id = id;
		this.nombreZona = nombreZona;
	}

	public Zona() {
		// TODO Auto-generated constructor stub
	}

}

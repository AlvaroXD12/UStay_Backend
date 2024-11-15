package com.springboot.edificio_service.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Inmueble {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String descripcion;
	private boolean disponibilidad;
	private double precio;
	private int n_cuarto;
	private boolean ilove;

	@ManyToOne
	private Edificio edificio;

	@OneToMany(mappedBy = "inmueble")
	@JsonIgnore
	private List<Servicios> servicio;
	
	@OneToMany(mappedBy = "inmueble")
	@JsonIgnore
	private List<Especificaciones> especificacion;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getN_cuarto() {
		return n_cuarto;
	}

	public void setN_cuarto(int n_cuarto) {
		this.n_cuarto = n_cuarto;
	}

	public boolean isIlove() {
		return ilove;
	}

	public void setIlove(boolean ilove) {
		this.ilove = ilove;
	}

	public Edificio getEdificio() {
		return edificio;
	}

	public void setEdificio(Edificio edificio) {
		this.edificio = edificio;
	}

	public Inmueble(int id, String descripcion, boolean disponibilidad, double precio, int n_cuarto, boolean ilove,
			Edificio edificio) {
		this.id = id;
		this.descripcion = descripcion;
		this.disponibilidad = disponibilidad;
		this.precio = precio;
		this.n_cuarto = n_cuarto;
		this.ilove = ilove;
		this.edificio = edificio;
	}

	public Inmueble() {
		// TODO Auto-generated constructor stub
	}

}

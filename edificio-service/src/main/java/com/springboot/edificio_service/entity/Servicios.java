package com.springboot.edificio_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Servicios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String Luz;
	private String Agua;
	private String Wifi;
	private String Cable;
	private String Garaje;
	private String Almacén;
	private String Lavandería;
	private String Seguridad;
	private String Pensión;
	private String Limpieza;
	private String Calefacción;
	
	@ManyToOne
	private Inmueble inmueble;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLuz() {
		return Luz;
	}
	public void setLuz(String luz) {
		Luz = luz;
	}
	public String getAgua() {
		return Agua;
	}
	public void setAgua(String agua) {
		Agua = agua;
	}
	public String getWifi() {
		return Wifi;
	}
	public void setWifi(String wifi) {
		Wifi = wifi;
	}
	public String getCable() {
		return Cable;
	}
	public void setCable(String cable) {
		Cable = cable;
	}
	public String getGaraje() {
		return Garaje;
	}
	public void setGaraje(String garaje) {
		Garaje = garaje;
	}
	public String getAlmacén() {
		return Almacén;
	}
	public void setAlmacén(String almacén) {
		Almacén = almacén;
	}
	public String getLavandería() {
		return Lavandería;
	}
	public void setLavandería(String lavandería) {
		Lavandería = lavandería;
	}
	public String getSeguridad() {
		return Seguridad;
	}
	public void setSeguridad(String seguridad) {
		Seguridad = seguridad;
	}
	public String getPensión() {
		return Pensión;
	}
	public void setPensión(String pensión) {
		Pensión = pensión;
	}
	public String getLimpieza() {
		return Limpieza;
	}
	public void setLimpieza(String limpieza) {
		Limpieza = limpieza;
	}
	public String getCalefacción() {
		return Calefacción;
	}
	public void setCalefacción(String calefacción) {
		Calefacción = calefacción;
	}
	
	public Inmueble getInmueble() {
		return inmueble;
	}
	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}
	
	public Servicios(int id, String luz, String agua, String wifi, String cable, String garaje, String almacén,
			String lavandería, String seguridad, String pensión, String limpieza, String calefacción,
			Inmueble inmueble) {
		this.id = id;
		Luz = luz;
		Agua = agua;
		Wifi = wifi;
		Cable = cable;
		Garaje = garaje;
		Almacén = almacén;
		Lavandería = lavandería;
		Seguridad = seguridad;
		Pensión = pensión;
		Limpieza = limpieza;
		Calefacción = calefacción;
		this.inmueble = inmueble;
	}
	
	public Servicios() {
		// TODO Auto-generated constructor stub
	}
	
}

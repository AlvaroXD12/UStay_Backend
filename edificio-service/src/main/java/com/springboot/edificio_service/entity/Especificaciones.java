package com.springboot.edificio_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Especificaciones {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String url_img;
	private String especificación1;
	private String url_img2;
	private String especificación2;
	private String url_img3;
	private String especificación3;
	private String url_img4;
	private String especificación4;
	private String url_img5;
	private String especificación5;
	private String url_img6;
	private String especificación6;

	@ManyToOne
	private Inmueble inmueble;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl_img() {
		return url_img;
	}

	public void setUrl_img(String url_img) {
		this.url_img = url_img;
	}

	public String getEspecificación1() {
		return especificación1;
	}

	public void setEspecificación1(String especificación1) {
		this.especificación1 = especificación1;
	}

	public String getUrl_img2() {
		return url_img2;
	}

	public void setUrl_img2(String url_img2) {
		this.url_img2 = url_img2;
	}

	public String getEspecificación2() {
		return especificación2;
	}

	public void setEspecificación2(String especificación2) {
		this.especificación2 = especificación2;
	}

	public String getUrl_img3() {
		return url_img3;
	}

	public void setUrl_img3(String url_img3) {
		this.url_img3 = url_img3;
	}

	public String getEspecificación3() {
		return especificación3;
	}

	public void setEspecificación3(String especificación3) {
		this.especificación3 = especificación3;
	}

	public String getUrl_img4() {
		return url_img4;
	}

	public void setUrl_img4(String url_img4) {
		this.url_img4 = url_img4;
	}

	public String getEspecificación4() {
		return especificación4;
	}

	public void setEspecificación4(String especificación4) {
		this.especificación4 = especificación4;
	}

	public String getUrl_img5() {
		return url_img5;
	}

	public void setUrl_img5(String url_img5) {
		this.url_img5 = url_img5;
	}

	public String getEspecificación5() {
		return especificación5;
	}

	public void setEspecificación5(String especificación5) {
		this.especificación5 = especificación5;
	}

	public String getUrl_img6() {
		return url_img6;
	}

	public void setUrl_img6(String url_img6) {
		this.url_img6 = url_img6;
	}

	public String getEspecificación6() {
		return especificación6;
	}

	public void setEspecificación6(String especificación6) {
		this.especificación6 = especificación6;
	}

	public Inmueble getInmueble() {
		return inmueble;
	}

	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}

	public Especificaciones(String id, String url_img, String especificación1, String url_img2, String especificación2,
			String url_img3, String especificación3, String url_img4, String especificación4, String url_img5,
			String especificación5, String url_img6, String especificación6, Inmueble inmueble) {
		this.id = id;
		this.url_img = url_img;
		this.especificación1 = especificación1;
		this.url_img2 = url_img2;
		this.especificación2 = especificación2;
		this.url_img3 = url_img3;
		this.especificación3 = especificación3;
		this.url_img4 = url_img4;
		this.especificación4 = especificación4;
		this.url_img5 = url_img5;
		this.especificación5 = especificación5;
		this.url_img6 = url_img6;
		this.especificación6 = especificación6;
		this.inmueble = inmueble;
	}

	public Especificaciones() {
		// TODO Auto-generated constructor stub
	}
}

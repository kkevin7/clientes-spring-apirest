package com.kevin.springboot.backend.apirest.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="alumnos")
public class Alumno implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable=false)
	private String apellidos;
	
	@Column(nullable=false)
	private String carnet;
	
	@ManyToOne
	@JoinColumn(name= "grado")
	private Grado grado;
	
	@Column(nullable=false)
	private String nombrePadre;
	
	@Column(nullable=false)
	private String nombreMadre;

	@Column(nullable=false)
	private String edad;
	
	@Column(nullable=false)
	private Float notaFinal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCarnet() {
		return carnet;
	}

	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}

	public Grado getGrado() {
		return grado;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}

	public String getNombrePadre() {
		return nombrePadre;
	}

	public void setNombrePadre(String nombrePadre) {
		this.nombrePadre = nombrePadre;
	}

	public String getNombreMadre() {
		return nombreMadre;
	}

	public void setNombreMadre(String nombreMadre) {
		this.nombreMadre = nombreMadre;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public Float getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(Float notaFinal) {
		this.notaFinal = notaFinal;
	}

	
	
}

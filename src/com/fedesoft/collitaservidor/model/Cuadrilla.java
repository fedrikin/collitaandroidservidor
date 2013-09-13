package com.fedesoft.collitaservidor.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cuadrilla {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;
	private String nombre;
	private Integer numeroCollidors;
	private String telefono;
	private boolean activa;
	
	public void setId(Integer id){
		this.id=id;
	}
	
	public Integer getId(){
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNumeroCollidors() {
		return numeroCollidors;
	}

	public void setNumeroCollidors(Integer numeroCollidors) {
		this.numeroCollidors = numeroCollidors;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String toString(){
		return nombre;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}
	
	

}

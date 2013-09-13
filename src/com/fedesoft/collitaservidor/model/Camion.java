package com.fedesoft.collitaservidor.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Table;


@Entity
public class Camion {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;
	private String nombre;
	private String conductor;
	private String telefono;
	private Integer cajonesMaximo;
	private boolean activo;
	// modificaci�g2
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getConductor() {
		return conductor;
	}
	public void setConductor(String conductor) {
		this.conductor = conductor;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Integer getCajonesMaximo() {
		return cajonesMaximo;
	}
	public void setCajonesMaximo(Integer cajonesMaximo) {
		this.cajonesMaximo = cajonesMaximo;
	}
	public String toString(){
		return nombre;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}

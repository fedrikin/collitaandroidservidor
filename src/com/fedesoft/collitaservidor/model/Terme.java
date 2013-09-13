package com.fedesoft.collitaservidor.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Terme {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;
	private String nombre;
	private Double precioKilo;
	
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
	public Double getPrecioKilo() {
		return precioKilo;
	}
	public void setPrecioKilo(Double precioKilo) {
		this.precioKilo = precioKilo;
	}
	public String toString(){
		return nombre;
	}
}

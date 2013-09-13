package com.fedesoft.collitaservidor.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Variedad {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;
	private String nombre;
	private Double precioKiloCollita;
	private Double precioMedioCompra;
	private Integer kilosPorCajon;
	 
	
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
	public Double getPrecioKiloCollita() {
		return precioKiloCollita;
	}
	public void setPrecioKiloCollita(Double precioKilo) {
		this.precioKiloCollita = precioKilo;
	}
	public String toString(){
		return nombre;
	}
	public Double getPrecioMedioCompra() {
		return precioMedioCompra;
	}
	public void setPrecioMedioCompra(Double precioMedioCompra) {
		this.precioMedioCompra = precioMedioCompra;
	}
	public Integer getKilosPorCajon() {
		return kilosPorCajon;
	}
	public void setKilosPorCajon(Integer kilosPorCajon) {
		this.kilosPorCajon = kilosPorCajon;
	}
}

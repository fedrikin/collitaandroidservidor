
package com.fedesoft.collitaservidor.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class OrdenCollita {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;
	private Cuadrilla cuadrilla;
	private Camion camion;
	private Comprador comprador;
	private Terme terme;
	private Variedad variedad;
	private Integer cajonesPrevistos;
	@Temporal(value = TemporalType.DATE)
	private Date fechaCollita;
	private String propietario;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Cuadrilla getCuadrilla() {
		return cuadrilla;
	}
	public void setCuadrilla(Cuadrilla cuadrilla) {
		this.cuadrilla = cuadrilla;
	}
	public Camion getCamion() {
		return camion;
	}
	public void setCamion(Camion camion) {
		this.camion = camion;
	}
	public Comprador getComprador() {
		return comprador;
	}
	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}
	public Terme getTerme() {
		return terme;
	}
	public void setTerme(Terme terme) {
		this.terme = terme;
	}
	public Variedad getVariedad() {
		return variedad;
	}
	public void setVariedad(Variedad variedad) {
		this.variedad = variedad;
	}
	public Integer getCajonesPrevistos() {
		return cajonesPrevistos;
	}
	public void setCajonesPrevistos(Integer cajonesPrevistos) {
		this.cajonesPrevistos = cajonesPrevistos;
	}
	public Date getFechaCollita() {
		return fechaCollita;
	}
	public void setFechaCollita(Date fechaCollita) {
		this.fechaCollita = fechaCollita;
	}
	public String getPropietario() {
		return propietario;
	}
	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}
	
	

}

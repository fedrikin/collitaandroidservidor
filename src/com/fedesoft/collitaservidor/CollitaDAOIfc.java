package com.fedesoft.collitaservidor;

import java.util.Date;
import java.util.List;

import com.fedesoft.collitaservidor.exceptions.CamionYaExisteException;
import com.fedesoft.collitaservidor.exceptions.CompradorYaExisteException;
import com.fedesoft.collitaservidor.exceptions.CuadrillaYaExisteException;
import com.fedesoft.collitaservidor.exceptions.TermeYaExisteException;
import com.fedesoft.collitaservidor.exceptions.VariedadYaExisteException;
import com.fedesoft.collitaservidor.model.Camion;
import com.fedesoft.collitaservidor.model.Comprador;
import com.fedesoft.collitaservidor.model.Cuadrilla;
import com.fedesoft.collitaservidor.model.OrdenCollita;
import com.fedesoft.collitaservidor.model.Terme;
import com.fedesoft.collitaservidor.model.Variedad;

public interface CollitaDAOIfc {

	public  Cuadrilla getCuadrillaById(Integer id);
		
	public abstract void actualizarCuadrilla(Cuadrilla cuadrilla);

	public abstract void guardarCuadrilla(Cuadrilla cuadrilla)
			throws CuadrillaYaExisteException;

	public abstract List<Cuadrilla> recuperarCuadrillas(Boolean activas);	
	
	public abstract Cuadrilla buscarCuadrillaPorNombre(String nombre);

	public abstract Camion getCamionById(Integer id);

	public abstract void actualizarCamion(Camion camion);

	public abstract void guardarCamion(Camion camion)
			throws CamionYaExisteException;

	public abstract List<Camion> recuperarCamiones(Boolean activos);

	public abstract Camion buscarCamionPorNombre(String nombre);

	public abstract Comprador getCompradorById(Integer id);

	public abstract void actualizarComprador(Comprador comprador);

	public abstract void guardarComprador(Comprador comprador)
			throws CompradorYaExisteException;

	public abstract List<Comprador> recuperarCompradores(Boolean activos);

	public  Comprador buscarCompradorPorNombre(String nombre);

	public  Terme getTermeById(Integer id);

	public abstract void actualizaTerme(Terme terme);

	public abstract void guardarTerme(Terme terme)
			throws TermeYaExisteException;

	public abstract List<Terme> recuperarTermes();

	public abstract Terme buscarTermePorNombre(String nombre);


	public abstract Variedad getVariedadById(Integer id);

	public abstract void actualizaVariedad(Variedad variedad);

	public abstract void guardarVariedad(Variedad variedad)
			throws VariedadYaExisteException;

	public abstract List<Variedad> recuperarVariedades();

	public abstract Variedad buscarVariedadPorNombre(String nombre);

	public abstract OrdenCollita getOrdenCollitaById(Integer id);

	public abstract void actualizarOrdenCollita(OrdenCollita ordencollita);

	public abstract void guardarOrdenCollita(OrdenCollita ordencollita);

	public abstract List<OrdenCollita> recuperarOrdenesCollita();

	public abstract List<OrdenCollita> recuperarOrdenesCollita(Date fecha);

	public List<OrdenCollita> recuperarOrdenesCollita(Date desde, Date hasta);

	public void borraOrdenCollita(OrdenCollita ordencollita);

}
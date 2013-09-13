package com.fedesoft.collitaservidor;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

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

public class CollitaDAOJPA implements CollitaDAOIfc {
	private EntityManager em;

	public CollitaDAOJPA(){
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("CollitaDAOServidor");
		em=emf.createEntityManager();
	}
	
	@Override
	public Cuadrilla getCuadrillaById(Integer id) {
		return em.find(Cuadrilla.class,id);
	}

	@Override
	public void actualizarCuadrilla(Cuadrilla cuadrilla) {
		// TODO Auto-generated method stub

	}

	@Override
	public void guardarCuadrilla(Cuadrilla cuadrilla)
			throws CuadrillaYaExisteException {
		if (buscarCuadrillaPorNombre(cuadrilla.getNombre()) != null){
			throw new CuadrillaYaExisteException();
		}
		em.getTransaction().begin();
		em.persist(cuadrilla);
		em.getTransaction().commit();
	}

	@Override
	public List<Cuadrilla> recuperarCuadrillas(Boolean activas) {
		Query q=em.createQuery("Select c From Cuadrilla c Where c.activa=true");	
		List<Cuadrilla> resultList = q.getResultList();
		return resultList;
	}

	@Override
	public List<Cuadrilla> buscarCuadrillasPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cuadrilla buscarCuadrillaPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Camion getCamionById(Integer id) {
		return em.find(Camion.class, id);		 
	}

	@Override
	public void actualizarCamion(Camion camion) {
		// TODO Auto-generated method stub

	}

	@Override
	public void guardarCamion(Camion camion) throws CamionYaExisteException {
		if (buscarCamionPorNombre(camion.getNombre()) != null){
			throw new CamionYaExisteException();
		}
		em.persist(camion);
	}

	@Override
	public List<Camion> recuperarCamiones(Boolean activos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Camion buscarCamionPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comprador getCompradorById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizarComprador(Comprador comprador) {
		// TODO Auto-generated method stub

	}

	@Override
	public void guardarComprador(Comprador comprador)
			throws CompradorYaExisteException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Comprador> recuperarCompradores(Boolean activos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comprador buscarCompradorPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Terme getTermeById(Integer id) {
		return em.find(Terme.class, id);
	}

	@Override
	public void actualizaTerme(Terme terme) {
		em.refresh(terme);
	}

	@Override
	public void guardarTerme(Terme terme) throws TermeYaExisteException {
		if (buscarTermePorNombre(terme.getNombre())!=null){
			throw new TermeYaExisteException();
		}
		em.getTransaction().begin();
		em.persist(terme);
		em.getTransaction().commit();

	}

	@Override
	public List<Terme> recuperarTermes() {		
		return em.createQuery("select t from Terme").getResultList();
	}

	@Override
	public Terme buscarTermePorNombre(String nombre) {
		Query query = em.createQuery("select t from Terme t where t.nombre=:nomTerme");
		query.setParameter("nomTerme",nombre);
		if (query.getResultList().size()==0){
			return null;
		}
		return (Terme) query.getSingleResult();
	}

	@Override
	public Variedad getVariedadById(Integer id) {
		return null;
	}

	@Override
	public void actualizaVariedad(Variedad variedad) {
		// TODO Auto-generated method stub

	}

	@Override
	public void guardarVariedad(Variedad variedad)
			throws VariedadYaExisteException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Variedad> recuperarVariedades() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Variedad buscarVariedadPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrdenCollita getOrdenCollitadById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizarOrdenCollita(OrdenCollita ordencollita) {
		// TODO Auto-generated method stub

	}

	@Override
	public void guardarOrdenCollita(OrdenCollita ordencollita) {
		em.persist(ordencollita);

	}

	@Override
	public List<OrdenCollita> recuperarOrdenesCollita() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdenCollita> recuperarOrdenesCollita(Date fecha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdenCollita> recuperarOrdenesCollita(Date desde, Date hasta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borraOrdenCollita(OrdenCollita ordencollita) {
		em.remove(ordencollita);
	}
	
	public static void main(String[] args) {
		CollitaDAOJPA collitaDAOJPA=new CollitaDAOJPA();
		Terme t=new Terme();
		t.setNombre("Mislata");
		t.setPrecioKilo(0.09d);
		try {
			collitaDAOJPA.guardarTerme(t);
		} catch (TermeYaExisteException e) {
			e.printStackTrace();
		}
	//	   collitaDAOJPA.recuperarCuadrillas(true);
	}

}

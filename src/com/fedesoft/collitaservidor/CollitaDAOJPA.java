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

	public CollitaDAOJPA() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("CollitaDAOServidor");
		em = emf.createEntityManager();
	}

	@Override
	public Cuadrilla getCuadrillaById(Integer id) {
		return em.find(Cuadrilla.class, id);
	}

	@Override
	public void actualizarCuadrilla(Cuadrilla cuadrilla) {
		em.refresh(cuadrilla);

	}

	@Override
	public void guardarCuadrilla(Cuadrilla cuadrilla)
			throws CuadrillaYaExisteException {
		if (buscarCuadrillaPorNombre(cuadrilla.getNombre()) != null) {
			throw new CuadrillaYaExisteException();
		}
		em.getTransaction().begin();
		em.persist(cuadrilla);
		em.getTransaction().commit();
	}

	@Override
	public List<Cuadrilla> recuperarCuadrillas(Boolean activas) {
		Query q;
		if (activas) {
			q = em.createQuery("Select c From Cuadrilla c Where c.activa=true");
		} else {
			q = em.createQuery("Select c From Cuadrilla c ");
		}
		List<Cuadrilla> resultList = q.getResultList();
		return resultList;
	}

	@Override
	public Cuadrilla buscarCuadrillaPorNombre(String nombre) {
		Query query = em
				.createQuery("select c from Cuadrilla c where c.nombre=:nomCuadrilla");
		query.setParameter("nomCuadrilla", nombre);
		if (query.getResultList().size() == 0) {
			return null;
		}
		return (Cuadrilla) query.getSingleResult();
	}

	// /////////////////
	@Override
	public Camion getCamionById(Integer id) {
		return em.find(Camion.class, id);
	}

	@Override
	public void actualizarCamion(Camion camion) {
		em.refresh(camion);

	}

	@Override
	public void guardarCamion(Camion camion) throws CamionYaExisteException {
		if (buscarTermePorNombre(camion.getNombre()) != null) {
			throw new CamionYaExisteException();
		}
		em.getTransaction().begin();
		em.persist(camion);
		em.getTransaction().commit();
	}

	@Override
	public List<Camion> recuperarCamiones(Boolean activos) {
		Query q = em.createQuery("Select c From Camion c Where c.activa=true");
		List<Camion> resultList = q.getResultList();
		return resultList;
	}

	@Override
	public Camion buscarCamionPorNombre(String nombre) {
		Query query = em
				.createQuery("select c from Camion c where c.nombre=:nomCamion");
		query.setParameter("nomCamion", nombre);
		if (query.getResultList().size() == 0) {
			return null;
		}
		return (Camion) query.getSingleResult();
	}

	// //////////Comprador/////////////////
	@Override
	public Comprador getCompradorById(Integer id) {
		return em.find(Comprador.class, id);
	}

	@Override
	public void actualizarComprador(Comprador comprador) {
		em.refresh(comprador);
	}

	@Override
	public void guardarComprador(Comprador comprador)
			throws CompradorYaExisteException {
		if (buscarTermePorNombre(comprador.getNombre()) != null) {
			throw new CompradorYaExisteException();
		}
		em.getTransaction().begin();
		em.persist(comprador);
		em.getTransaction().commit();

	}

	@Override
	public List<Comprador> recuperarCompradores(Boolean activos) {
		Query q = em
				.createQuery("Select c From Comprador c Where c.activa=true");
		List<Comprador> resultList = q.getResultList();
		return resultList;
	}

	@Override
	public Comprador buscarCompradorPorNombre(String nombre) {
		Query query = em
				.createQuery("select c from Comprador c where c.nombre=:nomComprador");
		query.setParameter("nomComprador", nombre);
		if (query.getResultList().size() == 0) {
			return null;
		}
		return (Comprador) query.getSingleResult();
	}

	// //////TERME/////////////////////////////////////////////
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
		if (buscarTermePorNombre(terme.getNombre()) != null) {
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
		Query query = em
				.createQuery("select t from Terme t where t.nombre=:nomTerme");
		query.setParameter("nomTerme", nombre);
		if (query.getResultList().size() == 0) {
			return null;
		}
		return (Terme) query.getSingleResult();
	}

	// /////////////Variedad//////////
	@Override
	public Variedad getVariedadById(Integer id) {
		return em.find(Variedad.class, id);

	}

	@Override
	public void actualizaVariedad(Variedad variedad) {
		em.refresh(variedad);

	}

	@Override
	public void guardarVariedad(Variedad variedad)
			throws VariedadYaExisteException {
		if (buscarTermePorNombre(variedad.getNombre()) != null) {
			throw new VariedadYaExisteException();
		}
		em.getTransaction().begin();
		em.persist(variedad);
		em.getTransaction().commit();
	}

	@Override
	public List<Variedad> recuperarVariedades() {
		return em.createQuery("select v from Variedad").getResultList();
	}

	@Override
	public Variedad buscarVariedadPorNombre(String nombre) {
		Query query = em
				.createQuery("select v from Variedad v where v.nombre=:nomVariedad");
		query.setParameter("nomVariedad", nombre);
		if (query.getResultList().size() == 0) {
			return null;
		}
		return (Variedad) query.getSingleResult();
	}

	// ////////////ordencollita////////////////////////
	@Override
	public OrdenCollita getOrdenCollitaById(Integer id) {
		return em.find(OrdenCollita.class, id);
	}

	@Override
	public void actualizarOrdenCollita(OrdenCollita ordencollita) {
		em.refresh(ordencollita);

	}

	@Override
	public void guardarOrdenCollita(OrdenCollita ordencollita) {
		em.persist(ordencollita);

	}

	@Override
	public List<OrdenCollita> recuperarOrdenesCollita() {
		return em.createQuery("select oc from OrdenCollita").getResultList();
	}

	@Override
	public List<OrdenCollita> recuperarOrdenesCollita(Date fecha) {
		Query q = em
				.createQuery("Select o From OrdenCollita oc Where oc.fechacollita=fecha");
		List<OrdenCollita> resultList = q.getResultList();
		return resultList;
	}

	@Override
	public List<OrdenCollita> recuperarOrdenesCollita(Date desde, Date hasta) {
		Query q = em
				.createQuery("Select o From Ordencollita oc where oc.fechacollita >= desde AND fechacollita <= hasta");
		List<OrdenCollita> resultList = q.getResultList();
		return resultList;
	}

	@Override
	public void borraOrdenCollita(OrdenCollita ordencollita) {
		em.remove(ordencollita);
	}

	public static void main(String[] args) {
		CollitaDAOJPA collitaDAOJPA = new CollitaDAOJPA();
		Terme t = new Terme();
		t.setNombre("Mislata");
		t.setPrecioKilo(0.09d);
		try {
			collitaDAOJPA.guardarTerme(t);
		} catch (TermeYaExisteException e) {
			e.printStackTrace();
		}
		// collitaDAOJPA.recuperarCuadrillas(true);
	}

}

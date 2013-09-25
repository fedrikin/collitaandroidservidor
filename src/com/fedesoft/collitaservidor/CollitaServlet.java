package com.fedesoft.collitaservidor;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.google.gson.Gson;

/**
 * Servlet implementation class CollitaServlet
 */
@WebServlet("/CollitaServlet")
public class CollitaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CollitaDAOIfc collitaDAO;
	private Gson gson = new Gson();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CollitaServlet() {
		super();
		collitaDAO = new CollitaDAOJPA();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		response.setContentType("text/json");
		ServletOutputStream out = response.getOutputStream();
		if (op.equals("recuperacamion")) {
			Integer camionId = Integer.parseInt(request.getParameter("id"));
			Camion camion = collitaDAO.getCamionById(camionId);
			String camionJson = gson.toJson(camion);
			out.println(camionJson);
		}
		if (op.equals("recuperacuadrilla")) {
			Integer id = Integer.parseInt(request.getParameter("id"));
			Cuadrilla cuadrilla = collitaDAO.getCuadrillaById(id);
			String cuadrillaJson = gson.toJson(cuadrilla);
			out.println(cuadrillaJson);
		}

		if (op.equals("recuperaterme")) {
			Integer id = Integer.parseInt(request.getParameter("id"));
			Terme terme = collitaDAO.getTermeById(id);
			String termeJson = gson.toJson(terme);
			out.println(termeJson);
		}
		if (op.equals("recuperavarietat")) {
			Integer id = Integer.parseInt(request.getParameter("id"));
			Variedad variedad = collitaDAO.getVariedadById(id);
			String variedadJson = gson.toJson(variedad);
			out.println(variedadJson);
		}
		if (op.equals("recuperacomprador")) {
			Integer id = Integer.parseInt(request.getParameter("id"));
			Comprador comprador = collitaDAO.getCompradorById(id);
			String compradorJson = gson.toJson(comprador);
			out.println(compradorJson);
		}
		if (op.equals("guardarcamion")) {
			String camionJson = request.getParameter("json");
			Camion camion = gson.fromJson(camionJson, Camion.class);
			try {
				collitaDAO.guardarCamion(camion);
			} catch (CamionYaExisteException e) {
				out.print("error - camion ya existe");
				e.printStackTrace();
			}
		}
		if (op.equals("guardarcuadrilla")) {
			String cuadrillaJson = request.getParameter("json");
			Cuadrilla cuadrilla = gson.fromJson(cuadrillaJson, Cuadrilla.class);
			try {
				collitaDAO.guardarCuadrilla(cuadrilla);
			} catch (CuadrillaYaExisteException e) {
				out.print("error - cuadrilla ya existe");
				e.printStackTrace();
			}
		}
		if (op.equals("guardarvariedad")) {
			String variedadJson = request.getParameter("json");
			Variedad variedad = gson.fromJson(variedadJson, Variedad.class);
			try {
				collitaDAO.guardarVariedad(variedad);
			} catch (VariedadYaExisteException e) {
				out.print("error - variedad ya existe");
				e.printStackTrace();
			}
		}
		if (op.equals("guardarterme")) {
			String termeJson = request.getParameter("json");
			Terme terme = gson.fromJson(termeJson, Terme.class);
			try {
				collitaDAO.guardarTerme(terme);
			} catch (TermeYaExisteException e) {
				out.print("error - terme ya existe");
				e.printStackTrace();
			}
		}
		if (op.equals("guardarcomprador")) {
			String compradorJson = request.getParameter("json");
			Comprador comprador = gson.fromJson(compradorJson, Comprador.class);
			try {
				collitaDAO.guardarComprador(comprador);
			} catch (CompradorYaExisteException e) {
				out.print("error - comprador ya existe");
				e.printStackTrace();
			}
		}
		if (op.equals("actualizarcamion")) {
			String camionJson = request.getParameter("json");
			Camion camion = gson.fromJson(camionJson, Camion.class);
			collitaDAO.actualizarCamion(camion);
		}
		if (op.equals("actualizarcuadrilla")) {
			String cuadrillaJson = request.getParameter("json");
			Cuadrilla cuadrilla = gson.fromJson(cuadrillaJson, Cuadrilla.class);
			collitaDAO.actualizarCuadrilla(cuadrilla);
		}
		if (op.equals("actualizarvariedad")) {
			String variedadJson = request.getParameter("json");
			Variedad variedad = gson.fromJson(variedadJson, Variedad.class);
			collitaDAO.actualizaVariedad(variedad);
		}
		if (op.equals("actualizarterme")) {
			String termeJson = request.getParameter("json");
			Terme terme = gson.fromJson(termeJson, Terme.class);
			collitaDAO.actualizaTerme(terme);
		}
		if (op.equals("actualizarcomprador")) {
			String compradorJson = request.getParameter("json");
			Comprador comprador = gson.fromJson(compradorJson, Comprador.class);
			collitaDAO.actualizarComprador(comprador);
		}
		if (op.equals("recuperarcamiones")) {
			String activosParam = request.getParameter("activos");
			boolean activos = true;
			if (activosParam != null) {
				activos = Boolean.parseBoolean(activosParam);
			}
			List<Camion> camiones = collitaDAO.recuperarCamiones(activos);
			out.print(gson.toJson(camiones));
		}
		if (op.equals("recuperarcuadrillas")) {
			String activosParam = request.getParameter("activos");
			boolean activos = true;
			if (activosParam != null) {
				activos = Boolean.parseBoolean(activosParam);
			}
			List<Cuadrilla> cuadrillas = collitaDAO
					.recuperarCuadrillas(activos);
			out.print(gson.toJson(cuadrillas));
		}
		if (op.equals("recuperarcompradores")) {
			String activosParam = request.getParameter("activos");
			boolean activos = true;
			if (activosParam != null) {
				activos = Boolean.parseBoolean(activosParam);
			}
			List<Comprador> compradores = collitaDAO
					.recuperarCompradores(activos);
			out.print(gson.toJson(compradores));
		}
		if (op.equals("recuperartermes")) {
			List<Terme> termes = collitaDAO.recuperarTermes();
			out.print(gson.toJson(termes));
		}
		if (op.equals("recuperarvariedades")) {
			List<Variedad> variedades = collitaDAO.recuperarVariedades();
			out.print(gson.toJson(variedades));
		}
		if (op.equals("recuperacamionnombre")) {
			String nombre = request.getParameter("nombre");
			Camion camion = collitaDAO.buscarCamionPorNombre(nombre);
			String camionJson = gson.toJson(camion);
			out.println(camionJson);
			
			
		}
		if (op.equals("recuperacuadrillanombre")) {
			String nombre = request.getParameter("nombre");
			Cuadrilla cuadrilla = collitaDAO.buscarCuadrillaPorNombre(nombre);
			String cuadrillaJson = gson.toJson(cuadrilla);
		    out.println(cuadrillaJson);
//			response.setContentType("text/html");
//			out.print("<html><head><title>Datos cuadrilla</title></head><body><h1> Caudrilla:</h1>");
//			out.print("<br>nombre:"+cuadrilla.getNombre());
//			out.print("<br>numero collidors:"+cuadrilla.getNumeroCollidors());
//			out.print("<br>telefono:"+cuadrilla.getTelefono());
//			out.print("<body></html>");
		}
		if (op.equals("recuperacompradornombre")) {
			String nombre = request.getParameter("nombre");
			Comprador comprador = collitaDAO.buscarCompradorPorNombre(nombre);
			String compradorJson = gson.toJson(comprador);
			out.println(compradorJson);
		}
		if (op.equals("recuperatermenombre")) {
			String nombre = request.getParameter("nombre");
			Terme terme = collitaDAO.buscarTermePorNombre(nombre);
			String termeJson = gson.toJson(terme);
			out.println(termeJson);
		}
		if (op.equals("recuperavariedadnombre")) {
			String nombre = request.getParameter("nombre");
			Variedad variedad = collitaDAO.buscarVariedadPorNombre(nombre);
			String variedadJson = gson.toJson(variedad);
			out.println(variedadJson);
		}
		if (op.equals("recuperarOrdenesCollita")) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String desde = request.getParameter("desde");
			String hasta = request.getParameter("hasta");
			List<OrdenCollita> ordenesCollita=null;
			try {
				ordenesCollita = collitaDAO.recuperarOrdenesCollita(
						sdf.parse(desde), sdf.parse(hasta));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			out.print(gson.toJson(ordenesCollita));
		}
		
		if (op.equals("recuperaordencollita")) {
			Integer ordenCollitaId = Integer.parseInt(request.getParameter("id"));
			OrdenCollita ordenCollita = collitaDAO.getOrdenCollitaById(ordenCollitaId);
			String ordenCollitaJson = gson.toJson(ordenCollita);
			out.println(ordenCollitaJson);
		}
		
		if (op.equals("guardarordencollita")) {
			String ordenCollitaJson = request.getParameter("json");
			OrdenCollita ordenCollita = gson.fromJson(ordenCollitaJson, OrdenCollita.class);			
			collitaDAO.guardarOrdenCollita(ordenCollita);			
		}
		if (op.equals("borrarordencollita")) {
			String ordenCollitaJson = request.getParameter("json");
			OrdenCollita ordenCollita = gson.fromJson(ordenCollitaJson, OrdenCollita.class);			
			collitaDAO.borraOrdenCollita(ordenCollita);			
		}
		
		if (op.equals("actualizarordencollita")) {
			String ordenCollitaJson = request.getParameter("json");
			OrdenCollita ordenCollita = gson.fromJson(ordenCollitaJson, OrdenCollita.class);			
			collitaDAO.actualizarOrdenCollita(ordenCollita);			
		}
		
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

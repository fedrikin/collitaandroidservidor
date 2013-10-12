package com.fedesoft.collitaservidor;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fedesoft.collitaservidor.exceptions.TermeYaExisteException;

import com.fedesoft.collitaservidor.model.Terme;

/**
 * Servlet implementation class NuevoTermeServlet
 */
@WebServlet("/NuevoTermeServlet")
public class NuevoTermeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CollitaDAOJPA collitaDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NuevoTermeServlet() {
		super();
		collitaDAO = new CollitaDAOJPA();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);			
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		ServletOutputStream out = response.getOutputStream();
		String nombre=request.getParameter("nombre");
		String precioKilo=request.getParameter("precio");
		Terme terme=new Terme();
		terme.setNombre(nombre);
		terme.setPrecioKilo(Double.parseDouble(precioKilo));
		out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Guardar terme</title>");            
        out.println("</head>");
        out.println("<body>");               
		try {
			collitaDAO.guardarTerme(terme);
			out.println("<h1>Terme guardat correctament</h1>");	        
		} catch (TermeYaExisteException e) {
			e.printStackTrace();
			out.println("<h1>El terme ja existix</h1>");
		}
		
		out.println("<a href=\"index.html\">Tornar</a>");
		out.println("</body>");
        out.println("</html>");
		out.close();
	}
}

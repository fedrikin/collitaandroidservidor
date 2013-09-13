package com.fedesoft.collitaservidor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fedesoft.collitaservidor.exceptions.CamionYaExisteException;
import com.fedesoft.collitaservidor.model.Camion;
import com.fedesoft.collitaservidor.model.Cuadrilla;
import com.google.gson.Gson;

/**
 * Servlet implementation class CollitaServlet
 */
@WebServlet("/CollitaServlet")
public class CollitaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CollitaDAOIfc collitaDAO;
	private Gson gson=new Gson();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CollitaServlet() {
        super();
        collitaDAO=new CollitaDAOJPA();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("op");
		response.setContentType("text/json");
		ServletOutputStream out = response.getOutputStream();
		if (op.equals("recuperacamion")){
			Integer camionId=Integer.parseInt(request.getParameter("id"));
			Camion camion=collitaDAO.getCamionById(camionId);
			String camionJson=gson.toJson(camion);						
			out.println(camionJson);			
		}				
		
		if (op.equals("recuperacuadrilla")){
			Integer id=Integer.parseInt(request.getParameter("id"));
			Cuadrilla cuadrilla=collitaDAO.getCuadrillaById(id);
			String cuadrillaJson=gson.toJson(cuadrilla);			
			out.println(cuadrillaJson);			
		}
		if (op.equals("guardarcamion")){
			String camionJson=request.getParameter("json");
			Camion camion=gson.fromJson(camionJson,Camion.class);
			try {
				collitaDAO.guardarCamion(camion);				
			} catch (CamionYaExisteException e) {
				out.print("error - camion ya existe");
				e.printStackTrace();
			}
		}
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

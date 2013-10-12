package com.fedesoft.collitaservidor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletOutputStream out = response.getOutputStream();
		String login=request.getParameter("login");
		String password=request.getParameter("password");
		if (login.equals("pepe") && password.equals("pepe")){
			request.getSession().setAttribute("login","true");
			response.sendRedirect("listarordenes.html");
		}else{
			out.println("<!DOCTYPE html>");
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Error de login</title>");            
	        out.println("</head>");
	        out.println("<body>");      
	    	out.println("Error de login");
			out.println("</body>");
	        out.println("</html>");
			out.close();
		}
	}

}

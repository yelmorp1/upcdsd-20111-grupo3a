package pe.edu.upc.dsd.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Votacion extends HttpServlet {
	private static final long serialVersionUID = 1L;      
   
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo = request.getParameter("tipo");
		if(tipo.equalsIgnoreCase("fCondUso"))
			response.sendRedirect(request.getContextPath()+"/fCondUso.jsp");
		else if(tipo.equalsIgnoreCase("fCedula"))
			response.sendRedirect(request.getContextPath()+"/fCedula.jsp");
		else if(tipo.equalsIgnoreCase("resumenVoto"))
			response.sendRedirect(request.getContextPath()+"/fCedula.jsp");
	}

	

}

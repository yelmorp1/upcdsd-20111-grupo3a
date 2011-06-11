package pe.edu.upc.dsd.votacion.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import pe.edu.upc.dsd.onpe.ws.ServiciosWeb;
import pe.edu.upc.dsd.votacion.model.BeanCandidato;


public class Votacion extends HttpServlet {
	private static final long serialVersionUID = 1L;      
   
	
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String tipo = request.getParameter("tipo");
			if(tipo.equalsIgnoreCase("fCondUso"))
				response.sendRedirect(request.getContextPath()+"/fCondUso.jsp");
			else if(tipo.equalsIgnoreCase("fCedula"))
					verCedula(request,response);
			else if(tipo.equalsIgnoreCase("resumenVoto"))
				response.sendRedirect(request.getContextPath()+"/fCedula.jsp");
			else if(tipo.equalsIgnoreCase("resumenPractica"))
				response.sendRedirect(request.getContextPath()+"/fResumenAT.jsp");
			else if(tipo.equalsIgnoreCase("votar"))
				response.sendRedirect(request.getContextPath()+"/fConfirmacionVoto.jsp");
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	public void verCedula(HttpServletRequest request,HttpServletResponse response) throws Exception{
		//ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
		ApplicationContext context= WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
		ServiciosWeb servicios = context.getBean("listadoCandidatosClient", ServiciosWeb.class);
		
		List<BeanCandidato>  candidatos = servicios.getListaCandidatos();	
		request.getSession().setAttribute("candidatos", candidatos);
		response.sendRedirect(request.getContextPath()+"/cedula.jsp");
	}

}




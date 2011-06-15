package pe.edu.upc.dsd.votacion.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import pe.edu.upc.dsd.onpe.ws.ServiciosWeb;
import pe.edu.upc.dsd.reniec.ws.ServicioReniec;
import pe.edu.upc.dsd.votacion.model.BeanCandidato;
import pe.edu.upc.dsd.votacion.model.BeanElector;
import pe.edu.upc.dsd.votacion.service.VotacionService;
import pe.edu.upc.dsd.votacion.service.VotacionServiceImpl;


public class Votacion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String tipo = request.getParameter("tipo");
			if(tipo.equalsIgnoreCase("fCondUso"))
				validarLogin(request,response);	
			else if(tipo.equalsIgnoreCase("fCedula"))
				verCedula(request,response);			
			else if(tipo.equalsIgnoreCase("votar"))
				votar(request,response);
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	
	//obtiene la lista de candidatos del WS de ONPE para poder generar la cedula
	public void verCedula(HttpServletRequest request,HttpServletResponse response) throws Exception{		
		ApplicationContext context= WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
		ServiciosWeb servicios = context.getBean("listadoServiciosOnpeClient", ServiciosWeb.class);		
		List<BeanCandidato>  candidatos = servicios.getListaCandidatos();	
		request.getSession().setAttribute("candidatos", candidatos);
		response.sendRedirect(request.getContextPath()+"/cedula.jsp");
	}
	
	
	//envia los votos a una cola para su registro
	public void votar(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ApplicationContext context= WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
		String seleccion = request.getParameter("seleccion");			
		VotacionService service = new VotacionServiceImpl(); //esta clase se encarga de enviar a la cola
		service.votar(seleccion, context);
		response.sendRedirect(request.getContextPath()+"/fConfirmacionVoto.jsp");
	}

	
	//obtiene la lista de electores del WS de RENIEC para poder validar el ingreso
	public void validarLogin(HttpServletRequest request,HttpServletResponse response) throws Exception{		
		
		//obtiene los datos ingresados en el formulario jsp
		String pin = request.getParameter("pin");
		String dni = request.getParameter("dni");
		String contrasena = request.getParameter("contrasena");
		String claveVerificacion = request.getParameter("claveVerificacion");
		
		//obtiene los clientes WS de RENIEC y ONPE del applicationContext
		ApplicationContext context= WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());		
		ServicioReniec serviciosReniec = context.getBean("listadoElectoresClient", ServicioReniec.class);
		ServiciosWeb serviciosOnpe = context.getBean("listadoServiciosOnpeClient", ServiciosWeb.class);		
		
		//envia los datos del elector a la ONPE para saber que ya entro a votar
		BeanElector electorLogueado = new BeanElector();
		electorLogueado.setPin(pin);
		electorLogueado.setDni(dni);
		electorLogueado.setClave(contrasena);
		serviciosOnpe.agregarElectorQueYaVoto(electorLogueado);
		
		//obtiene los electores habiles de RENIEC y valida el ingreso
		List<BeanElector> electores = serviciosReniec.getListaElectores();			
		boolean existe =false;
		for(BeanElector e : electores){
			if(e.getPin().equals(pin)&& e.getDni().equals(dni) && e.getClave().equals(contrasena) &&
			   claveVerificacion.equals("sy4sn4")){			
				existe =true;
				break;
			}else existe = false; 
		}
		if(existe) response.sendRedirect(request.getContextPath()+"/fCondUso.jsp");
		else response.sendRedirect(request.getContextPath()+"/fLogin.jsp?e=true");		
	}
}




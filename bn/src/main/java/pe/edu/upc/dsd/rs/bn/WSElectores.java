package pe.edu.upc.dsd.rs.bn;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.edu.upc.dsd.onpe.ws.ServiciosWeb;
import pe.edu.upc.dsd.reniec.model.BeanElector;
import pe.edu.upc.dsd.reniec.ws.ServicioReniec;

public class WSElectores {

	public List<BeanElector> getElectores(){
		ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
		ServicioReniec servicio = context.getBean("listadoElectoresClient", ServicioReniec.class);
		return servicio.getListaElectores();
	}
	
	public List<BeanElector> getElectoresQueVotaron(){
		ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
		ServiciosWeb servicio = context.getBean("listadoElectoresQueVotaronClient", ServiciosWeb.class);
		return servicio.getListaElectoresQueVotaron();
	}
	
}

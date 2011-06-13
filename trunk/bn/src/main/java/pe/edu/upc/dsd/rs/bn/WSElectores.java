package pe.edu.upc.dsd.rs.bn;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import pe.edu.upc.dsd.bn.model.BeanElector;
import pe.edu.upc.dsd.reniec.ws.ServicioReniec;
import pe.edu.upc.dsd.votacion.ws.ElectoresService;

public class WSElectores {

	public List<BeanElector> getElectores(){
		ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
		ServicioReniec servicio = context.getBean("listadoElectoresClient", ServicioReniec.class);
		return servicio.getListaElectores();
	}
	
	public List<BeanElector> getElectoresQueVotaron(){
		ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
		ElectoresService servicio = context.getBean("listadoElectoresQueVotaron", ElectoresService.class);
		return servicio.getElectoresQueVotaron();
	}
	
}

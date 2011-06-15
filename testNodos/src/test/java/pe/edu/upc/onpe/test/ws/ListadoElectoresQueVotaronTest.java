package pe.edu.upc.onpe.test.ws;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.edu.upc.dsd.onpe.ws.ServiciosWeb;

public class ListadoElectoresQueVotaronTest {

	private ServiciosWeb servicios;
	
	public ListadoElectoresQueVotaronTest()	{
		ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
		this.servicios = context.getBean("listadoServiciosOnpeClient", ServiciosWeb.class);
	}
	
	@Test
	public void testCantidadCandidatos() {
		Assert.assertEquals(1, servicios.getListaElectoresQueVotaron().size());
	}
	
}

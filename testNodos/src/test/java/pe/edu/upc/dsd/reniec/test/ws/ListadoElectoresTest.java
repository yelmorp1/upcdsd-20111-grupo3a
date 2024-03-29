package pe.edu.upc.dsd.reniec.test.ws;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.edu.upc.dsd.reniec.ws.ServicioReniec;

public class ListadoElectoresTest {
	private ServicioReniec servicio;
	
	public ListadoElectoresTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"/applicationContext.xml");
		this.servicio = context.getBean("listadoElectoresClient", ServicioReniec.class);
	}

	@Test
	public void testCantidadElectores() {
		Assert.assertEquals(31, servicio.getListaElectores().size());
	}
	
}

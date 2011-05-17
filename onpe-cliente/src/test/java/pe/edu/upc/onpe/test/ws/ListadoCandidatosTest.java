package pe.edu.upc.onpe.test.ws;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.edu.upc.dsd.onpe.ws.ServiciosWeb;

public class ListadoCandidatosTest {
	private ServiciosWeb servicios;

	public ListadoCandidatosTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"/applicationContext.xml");
		this.servicios = context.getBean("listadoCandidatosClient", ServiciosWeb.class);
	}

	@Test
	public void testTamanioLista() {
		Assert.assertEquals(4, servicios.getListaCandidatos().size());
	}
}
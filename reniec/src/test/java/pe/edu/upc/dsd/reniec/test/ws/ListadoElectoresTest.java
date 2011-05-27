package pe.edu.upc.dsd.reniec.test.ws;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.edu.upc.dsd.reniec.service.ElectorService;

public class ListadoElectoresTest {
	private ElectorService servicios;

	public ListadoElectoresTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"/applicationContext.xml");
		this.servicios = context.getBean("listadoCandidatosClient", ElectorService.class);
	}

	@Test
	public void testTamanioLista() {
		Assert.assertEquals(4, servicios.getListaElectores().size());
	}
}

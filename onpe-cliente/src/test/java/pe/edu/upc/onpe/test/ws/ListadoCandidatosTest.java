package pe.edu.upc.onpe.test.ws;



import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.edu.upc.dsd.onpe.model.BeanCandidato;
import pe.edu.upc.dsd.onpe.ws.ServiciosWeb;

public class ListadoCandidatosTest {
	private ServiciosWeb servicios;

	public ListadoCandidatosTest() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"/applicationContext.xml");
		this.servicios = context.getBean("listadoCandidatosClient", ServiciosWeb.class);
	}

	@Test
	public void testCantidadCandidatos() {
		Assert.assertEquals(11, servicios.getListaCandidatos().size());
	}
	
	
	@Test
	public void testEdadDePPK() {
		Assert.assertEquals(72, ((BeanCandidato)servicios.getListaCandidatos().get(1)).getEdad());
	}
	
	
	@Test
	public void testPartidoPoliticoKeiko() {
		Assert.assertEquals("Fuerza 2011", ((BeanCandidato)servicios.getListaCandidatos().get(0)).getPartidoPolitico());
		
	}
	
	
}
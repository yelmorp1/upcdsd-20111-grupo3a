package pe.edu.upc.onpe.test.ws;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pe.edu.upc.dsd.onpe.model.BeanCandidato;
import pe.edu.upc.dsd.onpe.model.BeanResultado;
import pe.edu.upc.dsd.onpe.ws.ServiciosWeb;

public class ListadoResultadoTest {

	private ServiciosWeb servicios;
	
	public ListadoResultadoTest()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(
		"/applicationContext.xml");
		this.servicios = context.getBean("listadoResultadosClient", ServiciosWeb.class);
	}
	
	@Test
	public void testObtenerResultados() {
		Assert.assertEquals(6, servicios.getObtenerResutados().size());
	}
	
	@Test
	public void testCantidadVotosOllanta() {
		Assert.assertEquals(100000, ((BeanResultado)servicios.getObtenerResutados().get(2)).getCantVotos());
	}
	
}

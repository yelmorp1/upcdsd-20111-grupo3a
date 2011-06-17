package pe.edu.upc.onpe.test.ws;

import org.junit.Assert;
import org.junit.Ignore;
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
	public void testCandidatos() {
		Assert.assertEquals(2, servicios.getObtenerResutados().size());
	}
	
	@Test
	public void testCantidadvotosInicial() {
		Assert.assertEquals(0, ((BeanResultado)servicios.getObtenerResutados().get(0)).getCantVotos());
		Assert.assertEquals(0, ((BeanResultado)servicios.getObtenerResutados().get(1)).getCantVotos());
	}
	
	@Test
	public void testCantidadVotos() {
		System.out.println("Votos Keiko: "+((BeanResultado)servicios.getObtenerResutados().get(0)).getCantVotos());
		System.out.println("Votos Ollanta: "+((BeanResultado)servicios.getObtenerResutados().get(1)).getCantVotos());
	}
}

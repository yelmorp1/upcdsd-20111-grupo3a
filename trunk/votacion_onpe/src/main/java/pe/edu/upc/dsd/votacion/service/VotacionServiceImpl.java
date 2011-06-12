package pe.edu.upc.dsd.votacion.service;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.support.WebApplicationContextUtils;

import pe.edu.upc.dsd.jms.MessageProducer;


public class VotacionServiceImpl implements VotacionService{


	
	@Override
	public void votar(String codReferenciaCandidato,ApplicationContext context) {
		try {
			MessageProducer messageProducer = (MessageProducer)context.getBean("queueMessageProducer");
			System.out.println("Enviando voto a la cola...");
			messageProducer.send("Voto por "+codReferenciaCandidato);
			System.out.println("Voto enviado...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

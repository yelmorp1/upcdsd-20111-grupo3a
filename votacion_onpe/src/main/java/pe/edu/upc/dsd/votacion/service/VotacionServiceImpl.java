package pe.edu.upc.dsd.votacion.service;

import org.springframework.context.ApplicationContext;

import pe.edu.upc.dsd.jms.MessageProducer;


public class VotacionServiceImpl implements VotacionService{


	
	@Override
	public void votar(String codReferenciaCandidato,ApplicationContext context) {
		try {
			MessageProducer messageProducer = (MessageProducer)context.getBean("queueMessageProducer");
			System.out.println("Enviando voto a la cola...");
			messageProducer.send(codReferenciaCandidato);
			System.out.println("Voto enviado.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

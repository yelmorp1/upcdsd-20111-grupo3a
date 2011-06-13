package pe.edu.upc.dsd.jms;

import java.util.UUID;

import javax.jms.Message;
import javax.jms.Queue;

import org.springframework.jms.core.JmsTemplate;

public class MessageProducer {
	
	private JmsTemplate jmsTemplate;
	private String requestDestination;
	private String responseDestination;

	public void send(final String message) {
		final String correlationId = UUID.randomUUID().toString();		
		jmsTemplate.convertAndSend(requestDestination, message,new CorrelationIdPostProcessor(correlationId));
		String voto = (String) jmsTemplate.receiveSelectedAndConvert(responseDestination,"JMSCorrelationID='" + correlationId + "'");
		System.out.println("Votó por: "+voto.toString());
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void setRequestDestination(String destinationName) {
		this.requestDestination = destinationName;
	}
	
	public void setResponseDestination(String responseDestination) {
		this.responseDestination = responseDestination;
	}
}

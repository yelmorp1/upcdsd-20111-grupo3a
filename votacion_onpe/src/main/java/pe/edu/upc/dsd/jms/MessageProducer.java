package pe.edu.upc.dsd.jms;

import java.util.UUID;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;

public class MessageProducer {
	
	private JmsTemplate jmsTemplate;
	private String requestDestination;
	private String responseDestination;

	public void send(final String message) {
		final String correlationId = UUID.randomUUID().toString();	
		jmsTemplate.convertAndSend(requestDestination, message,new CorrelationIdPostProcessor(correlationId));
		TextMessage voto = (TextMessage) jmsTemplate.receiveSelectedAndConvert(responseDestination,"JMSCorrelationID='" + correlationId + "'");
		try {
			System.out.println("Votó por: "+voto.getText());
		} catch (JMSException e) {			
			e.printStackTrace();
		}
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

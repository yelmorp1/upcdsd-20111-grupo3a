package pe.edu.upc.dsd.jms;

import org.springframework.jms.core.JmsTemplate;

public class MessageProducer {
	
	private JmsTemplate jmsTemplate;
	private String requestDestination;
	

	public void send(final String message) {
		jmsTemplate.convertAndSend(requestDestination, message);
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void setRequestDestination(String destinationName) {
		this.requestDestination = destinationName;
	}
	
	
}

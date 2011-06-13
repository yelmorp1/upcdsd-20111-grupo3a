package pe.edu.upc.dsd.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class MessageConsumer implements MessageListener {
	private static final Logger logger = Logger.getLogger(MessageConsumer.class);
	private JmsTemplate jmsTemplate;
	private String responseDestination;

	public void onMessage(final Message message) {
		if (message instanceof TextMessage) {
			final TextMessage textMessage = (TextMessage) message;
			try {				
				logger.debug("Recibiendo voto: " + textMessage.getText());
				jmsTemplate.send(responseDestination, new MessageCreator() {
					@Override
					public Message createMessage(Session session)throws JMSException {
						TextMessage responseMessage = session.createTextMessage();
						responseMessage.setJMSCorrelationID(textMessage.getJMSCorrelationID());
						responseMessage.setText(textMessage.toString());
						return responseMessage;
					}
				});
			} catch (final JMSException e) {
				e.printStackTrace();
			}
		}
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setResponseDestination(String responseDestination) {
		this.responseDestination = responseDestination;
	}

	public String getResponseDestination() {
		return responseDestination;
	}
}
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
	//private static final Logger logger = Logger.getLogger(MessageConsumer.class);


	public void onMessage(final Message message) {
		if (message instanceof TextMessage) {
			final TextMessage textMessage = (TextMessage) message;
			try {
				System.out.println("Recibiendo voto: " + textMessage.getText());
			} catch (final JMSException e) {
				e.printStackTrace();
			}
		}
	}

	
}
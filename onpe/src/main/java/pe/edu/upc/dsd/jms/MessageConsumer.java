package pe.edu.upc.dsd.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;

public class MessageConsumer implements MessageListener {
	private static final Logger logger = Logger.getLogger(MessageConsumer.class);

	public void onMessage(final Message message) {
		if (message instanceof TextMessage) {
			final TextMessage textMessage = (TextMessage) message;
			try {
				logger.debug("Recibiendo: " + textMessage.getText());
			} catch (final JMSException e) {
				e.printStackTrace();
			}
		}
	}
}
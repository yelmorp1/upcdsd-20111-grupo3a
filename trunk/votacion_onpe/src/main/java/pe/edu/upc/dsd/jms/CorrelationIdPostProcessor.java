package pe.edu.upc.dsd.jms;

import javax.jms.JMSException;
import javax.jms.Message;

import org.springframework.jms.core.MessagePostProcessor;

public class CorrelationIdPostProcessor implements MessagePostProcessor {

	private final String correlationId;

	public CorrelationIdPostProcessor(final String correlationId) {
		this.correlationId = correlationId;
	}

	@Override
	public Message postProcessMessage(final Message msg) throws JMSException {
		msg.setJMSCorrelationID(correlationId);
		return msg;
	}
}
package pe.edu.upc.dsd.jms;


import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


import pe.edu.upc.dsd.onpe.serviceImpl.ResultadoServiceImpl;

public class MessageConsumer implements MessageListener {
	//private static final Logger logger = Logger.getLogger(MessageConsumer.class);

	
	public static final String KEIKO="K";
	public static final String OLLANTA="O";
	
	
	public void onMessage(final Message message) {
		if (message instanceof TextMessage) {
			final TextMessage textMessage = (TextMessage) message;
			try {
				String voto_elector=textMessage.getText();
				System.out.println("Recibiendo voto: " + voto_elector);
				
				if(voto_elector.equals(KEIKO)){
					ResultadoServiceImpl.keiko.setCantVotos(ResultadoServiceImpl.keiko.getCantVotos()+1);
					
				}else if(voto_elector.equals(OLLANTA)){
					ResultadoServiceImpl.ollanta.setCantVotos(ResultadoServiceImpl.keiko.getCantVotos()+1);
				}
				
			} catch (final JMSException e) {
				e.printStackTrace();
			}
		}
	}

	
}
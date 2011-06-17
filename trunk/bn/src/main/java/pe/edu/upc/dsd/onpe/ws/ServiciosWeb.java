package pe.edu.upc.dsd.onpe.ws;

import java.util.List;
import javax.jws.WebService;

import pe.edu.upc.dsd.reniec.model.BeanElector;


@WebService
public interface ServiciosWeb {
	
	public List<BeanElector> getListaElectoresQueVotaron();


}

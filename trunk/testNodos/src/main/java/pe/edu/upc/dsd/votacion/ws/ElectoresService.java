package pe.edu.upc.dsd.votacion.ws;

import java.util.List;

import javax.jws.WebService;

import pe.edu.upc.dsd.reniec.model.BeanElector;



@WebService
public interface ElectoresService {

	public List<BeanElector> getElectoresQueVotaron();
	
}

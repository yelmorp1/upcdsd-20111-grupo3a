package pe.edu.upc.dsd.votacion.ws;

import java.util.List;

import javax.jws.WebService;

import pe.edu.upc.dsd.votacion.model.BeanCandidato;

@WebService
public interface ServiciosWeb {
	
	public List<BeanCandidato> getListaCandidatos();	
	

}

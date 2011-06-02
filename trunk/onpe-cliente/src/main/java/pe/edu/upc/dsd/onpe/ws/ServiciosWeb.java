package pe.edu.upc.dsd.onpe.ws;

import java.util.List;

import javax.jws.WebService;

import pe.edu.upc.dsd.onpe.model.BeanCandidato;


@WebService
public interface ServiciosWeb {
	
	public List<BeanCandidato> getListaCandidatos();
	

}

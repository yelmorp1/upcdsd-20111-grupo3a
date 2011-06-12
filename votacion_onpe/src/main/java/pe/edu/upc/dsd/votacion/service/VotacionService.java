package pe.edu.upc.dsd.votacion.service;

import org.springframework.context.ApplicationContext;

public interface VotacionService {

	public void votar(String codReferenciaCandidato,ApplicationContext context);		
	
	
}

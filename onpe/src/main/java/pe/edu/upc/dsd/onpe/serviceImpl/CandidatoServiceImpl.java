package pe.edu.upc.dsd.onpe.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.dsd.onpe.model.BeanCandidato;
import pe.edu.upc.dsd.onpe.service.CandidatoService;

public class CandidatoServiceImpl implements CandidatoService{

	public List<BeanCandidato> getListaCandidatos() {
		
		
		List  lstCandidatos = new ArrayList<BeanCandidato>();
		
		BeanCandidato candidato1 = new BeanCandidato();
		candidato1.setApellidos("Fujimori");
		candidato1.setNombre("Keiko");
		candidato1.setPartidoPolitico("Fuerza 2011");
		
		
		return null;
	}

}
